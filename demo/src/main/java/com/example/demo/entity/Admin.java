package com.example.demo.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    private String email;
    
    private String password; 
    
    @Column(name = "phonenumber")
    private String phonenumber;
    
    @ManyToOne
    @JoinColumn(name = "stores_id")
    private Store store;
    
    @JoinColumn(name = "roles_id") 
    private Role role;
    
    @Column(name = "authorities_id")
    private Long authoritiesId;
    
    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;
   
    //以下getter/setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    
    public Store getStore() {
    	return store;
    }
    public void setStore(Store store) {
    	this.store = store;
    }
    
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    
    public Long getAuthoritiesId() { 
    	return authoritiesId; 
    }   
    public void setAuthoritiesId(Long authoritiesId) {
    	this.authoritiesId = authoritiesId;
    }

    public Timestamp getCreatedAt() { 
    	return createdAt; 
    }
    
    public Timestamp getUpdatedAt() { 
    	return updatedAt;
    }
}