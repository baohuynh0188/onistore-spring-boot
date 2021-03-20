// package com.spring.onistore.model;

// import java.util.Collection;
// import java.util.List;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// public class CustomUserDetails implements UserDetails {

// private static final long serialVersionUID = 1L;
// private String userName;
// private String password;
// private List<GrantedAuthority> authorities;

// public CustomUserDetails(String userName, String password,
// List<GrantedAuthority> authorities) {
// this.userName = userName;
// this.password = password;
// this.authorities = authorities;
// }

// @Override
// public Collection<? extends GrantedAuthority> getAuthorities() {

// return authorities;
// }

// public String getUserName() {
// return userName;
// }

// public void setUserName(String userName) {
// this.userName = userName;
// }

// public void setPassword(String password) {
// this.password = password;
// }

// @Override
// public String getPassword() {
// // TODO Auto-generated method stub
// return null;
// }

// @Override
// public String getUsername() {
// // TODO Auto-generated method stub
// return null;
// }

// @Override
// public boolean isAccountNonExpired() {
// // TODO Auto-generated method stub
// return false;
// }

// @Override
// public boolean isAccountNonLocked() {
// // TODO Auto-generated method stub
// return false;
// }

// @Override
// public boolean isCredentialsNonExpired() {
// // TODO Auto-generated method stub
// return false;
// }

// @Override
// public boolean isEnabled() {
// // TODO Auto-generated method stub
// return false;
// }

// }
