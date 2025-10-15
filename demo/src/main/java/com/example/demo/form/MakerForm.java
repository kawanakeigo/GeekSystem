package com.example.demo.form;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "makers")
public class MakerForm {
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
