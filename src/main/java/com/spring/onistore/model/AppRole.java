// package com.spring.onistore.model;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;

// @Entity
// @Table(name = "APP_ROLE")
// public class AppRole {

// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// @Column(name = "ROLE_ID", nullable = false)
// private Long roleId;

// @Column(name = "ROLE_NAME", nullable = false)
// private String roleName;

// public AppRole() {
// }

// public Long getRoleId() {
// return roleId;
// }

// public String getRoleName() {
// return roleName;
// }

// public void setRoleName(String roleName) {
// this.roleName = roleName;
// }

// public void setRoleId(Long roleId) {
// this.roleId = roleId;
// }
// }