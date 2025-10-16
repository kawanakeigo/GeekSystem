package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    private Long id;
    private String name;
    
    //　以下getter/setter
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
}