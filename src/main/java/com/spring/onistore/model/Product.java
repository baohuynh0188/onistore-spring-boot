// package com.spring.onistore.model;

// import javax.persistence.*;
// import java.util.Set;

// @Entity
// @Table(name = "products")
// public class Product {
// @Id
// @GeneratedValue(strategy = GenerationType.AUTO)
// @Column(name = "p_id")
// private long productId;

// @Column(name = "p_name", nullable = false)
// private String productName;

// @Column(name = "p_description", nullable = true)
// private String productDescription;

// @Column(name = "p_slug", nullable = false)
// private String productSlug;

// @ManyToMany(cascade = CascadeType.ALL)
// @JoinTable(name = "product_categories", schema = "dbo", joinColumns =
// {@JoinColumn(referencedColumnName = "p_id")}, inverseJoinColumns =
// {@JoinColumn(referencedColumnName = "c_id")})
// private Set<Category> categories;

// public long getProductId() {
// return productId;
// }

// public void setProductId(long productId) {
// this.productId = productId;
// }

// public String getProductName() {
// return productName;
// }

// public void setProductName(String productName) {
// this.productName = productName;
// }

// public String getProductDescription() {
// return productDescription;
// }

// public void setProductDescription(String productDescription) {
// this.productDescription = productDescription;
// }

// public String getProductSlug() {
// return productSlug;
// }

// public void setProductSlug(String productSlug) {
// this.productSlug = productSlug;
// }

// public Set<Category> getCategories() {
// return categories;
// }

// public void setCategories(Set<Category> categories) {
// this.categories = categories;
// }
// }
