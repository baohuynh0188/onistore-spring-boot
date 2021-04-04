package com.spring.onistore.controller;

import java.util.HashMap;

import javax.validation.Valid;

import com.spring.onistore.dto.SignInDto;
import com.spring.onistore.dto.SignUpDto;
import com.spring.onistore.entity.User;
import com.spring.onistore.repository.UserRepository;
import com.spring.onistore.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @GetMapping
    public String get() {
        return "Hello";
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpDto signUpDto) {

        User newUser = new User();

        newUser.setEmail(signUpDto.getEmail());
        newUser.setUserName(signUpDto.getUserName());
        newUser.setEncryptedPassword(encoder().encode(signUpDto.getPassword()));

        userRepository.save(newUser);

        return new ResponseEntity<User>(newUser, HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> postMethodName(@RequestBody SignInDto signInDto) {
        // TODO: process POST request
        HashMap<String, String> error = new HashMap<>();
        User foundUser = userRepository.findByEmail(signInDto.getEmail());
        if (foundUser == null) {
            error.put("message", "User not found");
            return new ResponseEntity<>(error, HttpStatus.valueOf(401));
        }

        if (!encoder().matches(signInDto.getPassword(), foundUser.getEncryptedPassword())) {
            error.put("message", "Wrong email or password");
            return new ResponseEntity<>(error, HttpStatus.valueOf(401));
        }
        JwtUtil jwtUtil = new JwtUtil();

        String token = jwtUtil.generateToken(foundUser);

        error.put("accessToken", token);

        return ResponseEntity.ok().body(error);
    }

    @GetMapping("/protect")
    public String test() {
        return "This is protected";
    }

}
