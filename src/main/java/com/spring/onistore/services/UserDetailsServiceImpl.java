// package com.spring.onistore.services;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.logging.Logger;
// import com.spring.onistore.entities.AppUser;
// import com.spring.onistore.model.CustomUserDetails;
// import com.spring.onistore.repository.AppRoleRepository;
// import com.spring.onistore.repository.AppUserRepository;
// import com.spring.onistore.repository.UserRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import
// org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// @Service
// public class UserDetailsServiceImpl implements UserDetailsService {

// @Autowired
// private UserRepository userRepository;
// @Autowired
// private AppUserRepository appUserRepository;
// @Autowired
// private AppRoleRepository appRoleRepository;

// @Override
// public UserDetails loadUserByUsername(String userName) throws
// UsernameNotFoundException {

// AppUser appUser = appUserRepository.findByUserName(userName);

// if (appUser == null) {
// Logger.getLogger("error").info("User not found! " + userName);
// throw new UsernameNotFoundException("User " + userName + " was not found in
// the database");
// }

// Logger.getLogger("info").info("Found: " + appUser);

// List<String> roleNames =
// appRoleRepository.findByRoleName(appUser.getUserId());

// List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();

// if (roleNames != null) {
// for (String role : roleNames) {
// GrantedAuthority authority = new SimpleGrantedAuthority(role);
// grantList.add(authority);
// }
// }

// UserDetails userDetails = (UserDetails) new
// CustomUserDetails(appUser.getUserName(),
// appUser.getEncryptedPassword(), grantList);
// return userDetails;
// }

// }
