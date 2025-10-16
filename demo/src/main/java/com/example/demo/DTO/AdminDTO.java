package com.example.demo.DTO;

import java.sql.Timestamp;

import com.example.demo.entity.Role;
import com.example.demo.entity.Store;

public class AdminDTO {
    private Long id;
    
    private String firstNam;
    
    private String lastName;
    
    private String email;
    
    private String password; 
    
    private String phonenumber;
    
    private Store store;

    private Role role;

    private Long authoritiesId;

    private Timestamp createdAt;

    private Timestamp updatedAt;
   
    //　以下getter/setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstNam;
    }
    public void setFirstName(String firstName) {
        this.firstNam = firstName;
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