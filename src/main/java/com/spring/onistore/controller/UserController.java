package com.spring.onistore.controller;

import java.util.Random;

import javax.validation.Valid;

import com.spring.onistore.dto.UserDto;
import com.spring.onistore.model.User;
import com.spring.onistore.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
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
@RequestMapping("api/v2/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    // private String generateJWTToken(String userName) {
    // String secretString = "tHiSiSaVeRySeCrEcTsTrIng";

    // List<GrantedAuthority> grantedAuthorities =
    // AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

    // String token = Jwts.builder().setId("softtekJWT").setSubject(userName)
    // .claim("authorities",
    // grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
    // .setIssuedAt(new Date(System.currentTimeMillis()))
    // .setExpiration(new Date(System.currentTimeMillis() + 600000))
    // .signWith(SignatureAlgorithm.HS512, secretString.getBytes()).compact();

    // return "Bearer " + token;
    // }

    @GetMapping("/test")
    public int protectedRoute() {

        int randomNumber = new Random().nextInt(100);
        return randomNumber;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody UserDto userDto) {

        User newUser = new User();

        newUser.setEmail(userDto.getEmail());
        newUser.setUserName(userDto.getUserName());
        newUser.setEncryptedPassword(encoder().encode(userDto.getPassword()));

        userRepository.save(newUser);

        return new ResponseEntity<User>(newUser, HttpStatus.OK);
    }
}
