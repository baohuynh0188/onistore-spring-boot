package com.spring.onistore.repository;

import com.spring.onistore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findBySlug(String Slug);
}
