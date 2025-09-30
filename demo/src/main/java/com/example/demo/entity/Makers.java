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
	public String getName() {
		return name;
	}
}
