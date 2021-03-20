// package com.spring.onistore.entities;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.Table;
// import javax.persistence.UniqueConstraint;

// @Entity
// @Table(name = "APP_USER_ROLE")
// public class AppUserRole {
// @Id
// @GeneratedValue
// @Column(name = "ID", nullable = false)
// private Long id;

// @ManyToOne(fetch = FetchType.LAZY)
// @JoinColumn(name = "USER_ID", nullable = false)
// private AppUser appUser;

// @ManyToOne(fetch = FetchType.LAZY)
// @JoinColumn(name = "ROLE_ID", nullable = false)
// private AppRole appRole;

// public Long getId() {
// return id;
// }

// public AppRole getAppRole() {
// return appRole;
// }

// public void setAppRole(AppRole appRole) {
// this.appRole = appRole;
// }

// public AppUser getAppUser() {
// return appUser;
// }

// public void setAppUser(AppUser appUser) {
// this.appUser = appUser;
// }

// public void setId(Long id) {
// this.id = id;
// }
// }
