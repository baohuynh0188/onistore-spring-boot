package com.spring.onistore.repository;

import com.spring.onistore.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // User findByUserName(String userName);
    User findByEmail(String email);

    User findByUserName(String userName);
}
