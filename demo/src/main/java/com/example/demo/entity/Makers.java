package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "makers")
public class Makers {
	@Id
	private Long id;
	private String name;
    
	public Long getId() {
		return id;
	}
	public void setId( Long Id) {
		this.id = Id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
