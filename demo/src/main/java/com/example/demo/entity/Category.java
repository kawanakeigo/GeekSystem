package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private Category parent;
    @OneToMany(mappedBy = "parent")
    @JsonManagedReference
    private List<Category> children;
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Category getParent() {
        return parent;
    }
    public List<Category> getChildren() {
        return children;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setParent(Category parent) {
        this.parent = parent;
    }
    public void setChildren(List<Category> children) {
        this.children = children;
    }
}
