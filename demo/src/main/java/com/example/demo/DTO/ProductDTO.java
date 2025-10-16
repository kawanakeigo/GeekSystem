package com.example.demo.DTO;

public class ProductDTO {
    private Long id;
    private String name;
    private Long largeCategoryId;
    private Long middleCategoryId;
    private Long smallCategoryId;
    private Long makerId;
    private Double price;
    private String description;

    //以下getter/setter 
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

    public Long getLargeCategoryId() { 
    	return largeCategoryId; 
    }
    public void setLargeCategoryId(Long largeCategoryId) { 
    	this.largeCategoryId = largeCategoryId; 
    }

    public Long getMiddleCategoryId() { 
    	return middleCategoryId; 
    }
    public void setMiddleCategoryId(Long middleCategoryId) { 
    	this.middleCategoryId = middleCategoryId; 
    }

    public Long getSmallCategoryId() { 
    	return smallCategoryId; 
    }
    public void setSmallCategoryId(Long smallCategoryId) { 
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
