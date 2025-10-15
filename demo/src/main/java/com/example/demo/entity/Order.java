package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    
    private Long quantity;
    
    @Column(name = "large_categories_id")
    private Long largeCategoryId;
    
    @Column(name = "middle_categories_id")
    private Long middleCategoryId;
    
    @Column(name = "small_categories_id")
    private Long smallCategoryId;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
   
    private String status;
    
    //以下getter・setter
    public Admin getAdmin(Admin admin) {
    	return admin;
    }
    public void setAdmin(Admin admin) {
    	this.admin =admin;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public Store getStore() {
        return store;
    }
    public void setStore(Store store) {
        this.store = store;
    }
    
    public Long getQuantity() {
        return quantity;
    }
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
    
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    public LocalDateTime getCreatedAt() {
    	return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
    	this.createdAt = createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
    	return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
    	this.updatedAt = updatedAt;
    }
    
    public Long getLarge_categories_Id() {
        return largeCategoryId;
    }
    public void setLarge_categories_Id(Long largeCategoryId) {
        this.largeCategoryId = largeCategoryId;
    }
    
    public Long getMiddle_categories_Id() {
        return middleCategoryId;
    }
    public void setMiddle_categories_Id(Long middleCategoryId) {
        this.middleCategoryId = middleCategoryId;
    }
    
    public Long getSmall_categories_Id() {
        return smallCategoryId;
    }
    public void setSmall_categories_Id(Long smallCategoryId) {
        this.smallCategoryId = smallCategoryId;
    }
}
