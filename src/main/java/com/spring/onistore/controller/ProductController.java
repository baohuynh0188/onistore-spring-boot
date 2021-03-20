package com.spring.onistore.controller;

import com.spring.onistore.exception.ResourceNotFoundException;
import com.spring.onistore.model.Product;
import com.spring.onistore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.spring.onistore.util.Slugify.toSlug;

@RestController
@RequestMapping("api")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    // Show all products
    @GetMapping("products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get one product by id
    @GetMapping("product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId) throws ResourceNotFoundException {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product" + productId + "is not exist"));
        return ResponseEntity.ok().body(product);
    }

    // Get products by product name
    @GetMapping("products/{product_slug}")
    public ResponseEntity<List<Product>> getProductBySlug(@PathVariable(value = "product_slug") String productSlug) throws ResourceNotFoundException {
        List<Product> product = productRepository.findByProductSlug(productSlug);
        return ResponseEntity.ok().body(product);
    }

    // Create one product
    @PostMapping("product/add")
    public ResponseEntity<Product> createProduct(@Validated @RequestBody Product product) {
        product.setProductSlug(toSlug(product.getProductName()));
        Product saveProduct = productRepository.save(product);
        return ResponseEntity.ok().body(saveProduct);
    }

    // Delete one product
    @DeleteMapping("product/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId) throws ResourceNotFoundException{
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product" + productId + "is not exist"));
        productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    // Update product
    @PutMapping("product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productId, @Validated @RequestBody Product productDetail) throws ResourceNotFoundException{
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product" + productId + "is not exist"));
        product.setProductName(productDetail.getProductName());
        product.setProductDescription(productDetail.getProductDescription());
        product.setProductSlug(toSlug(productDetail.getProductName()));
        final Product productUpdated = productRepository.save(product);
        return ResponseEntity.ok().body(productUpdated);
    }

    @PostMapping("test")
    public ResponseEntity<Product> test(@RequestBody Product a) {
        System.out.println(a.getProductName());
        return  ResponseEntity.ok().body(a);
    }
}
