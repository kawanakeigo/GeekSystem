package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authority {
	
	@Id
	private Long Id;
	private String name;
    
    //以下getter/setter
	public Long getId() {
		return Id;
	}
	
	public String getName() {
		return name;
	}
}
