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
    
    //以下getter・setter
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public Long getLarge_categories_Id() {
        return largeCategoryId;
    }
    
    public Long getMiddle_categories_Id() {
        return middleCategoryId;
    }
    
    public Long getSmall_categories_Id() {
        return smallCategoryId;
    }
    
    public Long getMakerId() {
        return makerId;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public String getDescription() {
        return description;
    }
}
