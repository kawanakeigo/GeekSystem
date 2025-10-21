package com.example.demo.DTO;

public class SmallCategoryDTO {
	private Long id;
    private String name;
    private Long middleCategoriesId; 
    
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
    	this .name = name;
    }
    
    public Long getMiddleCategoriesId() {
    	return middleCategoriesId;
    }
    public void setMiddleCategoriesId(Long middleCategoriesId) {
    	this.middleCategoriesId = middleCategoriesId;
    }
}
