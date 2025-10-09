package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "large_categories")
public class LargeCategory {
	@Id
    private Long id;
    private String name;
    
    //以下gettersetter
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

}
