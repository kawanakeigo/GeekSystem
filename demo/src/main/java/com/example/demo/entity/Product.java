package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private Long id;
    private String name;
    
    @Column(name = "large_categories_id")
    private Long largeCategoryId;
    
    @Column(name = "middle_categories_id")
    private Long middleCategoryId;
    
    @Column(name = "small_categories_id")
    private Long smallCategoryId;
    
    @Column(name = "makers_id")
    private Long makerId;
    
    private Double price;
    
    private String description;
    
    //　以下getter/setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
    	this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
    	this.name = name;
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
    
    public Long getMakerId() {
        return makerId;
    }
    public void setMakerId(Long makerId) {
    	this.makerId = makerId;
    }
    
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
    	this.price = price;
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
    	this.description = description;
    }
}
