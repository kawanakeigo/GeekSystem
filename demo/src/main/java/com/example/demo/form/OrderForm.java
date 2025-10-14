package com.example.demo.form;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class OrderForm {
	@NotNull
    private Long productId;
	
	@NotNull
    private Long storeId;
	
	@NotNull
    @Min(value = 1)
    @Max(value = 1000)
    private Long quantity;
	
	private Long categoryId;
	
	@Column(name = "large_categories_id")
    private Long largeCategoryId;
    
    @Column(name = "middle_categories_id")
    private Long middleCategoryId;
    
    @Column(name = "small_categories_id")
    private Long smallCategoryId;
	
	//以下getter・setter
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    public Long getStoreId() {
        return storeId;
    }
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    
    public Long getQuantity() {
        return quantity;
    }
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
    
    public Long getCategoryId() { 
    	return categoryId; 
    	}
    public void setCategoryId(Long categoryId) {
    	this.categoryId = categoryId; 
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

