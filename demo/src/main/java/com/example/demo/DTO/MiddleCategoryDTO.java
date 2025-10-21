package com.example.demo.DTO;

public class MiddleCategoryDTO {
	private Long id;
    private String name;
    private Long largeCategoriesId;
    
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
    
    public Long getLargeCategoriesId() { 
    	return largeCategoriesId; 
    }
    public void setLargeCategoriesId(Long largeCategoriesId) {
    	this.largeCategoriesId = largeCategoriesId;
    }
}
