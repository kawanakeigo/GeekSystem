package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
    @Id
    private Long id;
    private String name;
    
    @Column(name = "category_id")
    private Long categoryId;
    
    @Column(name = "maker_id")
    private Long makerId;
    private Double price;
    
    @Column(name = "stock_quantity")
    private Integer stockQuantity;
    private String description;
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public Long getCategoryId() {
        return categoryId;
    }
    
    public Long getMakerId() {
        return makerId;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public Integer getStockQuantity() {
        return stockQuantity;
    }
    
    public String getDescription() {
        return description;
    }
}
