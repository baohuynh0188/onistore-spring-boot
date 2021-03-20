package com.spring.onistore.controller;

import com.spring.onistore.exception.ResourceNotFoundException;
import com.spring.onistore.model.Category;
import com.spring.onistore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.spring.onistore.util.Slugify.toSlug;

@RestController
@RequestMapping("api/v2")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("categories")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

//    // Get products by category name
//    @GetMapping("categories/{category_name}")
//    public ResponseEntity<List<Category>> getCategoryByName(@PathVariable(value = "category_name") String categoryName) throws ResourceNotFoundException {
//        List<Category> categories = categoryRepository.findByCategoryName(categoryName);
//        return ResponseEntity.ok().body(categories);
//    }

    // Get products by category slug
    @GetMapping("categories/{category_slug}")
    public ResponseEntity<List<Category>> getCategoryBySlug(@PathVariable(value = "category_slug") String categorySlug) throws ResourceNotFoundException {
        List<Category> categories = categoryRepository.findByCategorySlug(categorySlug);
        return ResponseEntity.ok().body(categories);
    }

    @PostMapping("categories/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        category.setCategorySlug(toSlug(category.getCategoryName()));
        Category saveCategory = categoryRepository.save(category);
        return ResponseEntity.ok().body(saveCategory);
    }

    @PutMapping("categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable(value = "id") Long categoryId, @RequestBody Category categoryDetail) throws ResourceNotFoundException {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category " + categoryId + " is not exist"));
        category.setCategoryName(categoryDetail.getCategoryName());
        category.setCategoryDescription(categoryDetail.getCategoryDescription());
        category.setCategorySlug(toSlug(categoryDetail.getCategoryName()));
        final Category categoryUpdated = categoryRepository.save(category);
        return ResponseEntity.ok().body(categoryUpdated);
    }

    @DeleteMapping("categories/{id}")
    public Map<String, Boolean> deleteCategory(@PathVariable(value = "id") Long categoryId) throws ResourceNotFoundException {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category " + categoryId + " is not exist"));
        categoryRepository.delete(category);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}