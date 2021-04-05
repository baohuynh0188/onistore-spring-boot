package com.spring.onistore.repository;

import com.spring.onistore.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findBySlug(String Slug);
}