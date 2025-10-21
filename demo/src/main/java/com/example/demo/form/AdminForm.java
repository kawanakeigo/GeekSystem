package com.example.demo.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AdminForm {
	private Long id;
	
    @NotBlank(message = "名は必須です")
    @Size(max = 50, message = "50文字以内で入力してください")
    private String firstName;
    
    @NotBlank(message = "性は必須です")
    @Size(max = 50, message = "50文字以内で入力してください")
    private String lastName;
    
    @NotBlank(message = "メールアドレスは必須です")
    @Email(message = "メールアドレスの形式で入力してください")
    @Size(max = 50 , message = "50文字以内で入力してください")
    private String email;
    
    @NotBlank(message = "電話番号は必須です")
    @Size(max = 20 , message = "20文字以内で入力してください")
    private String phonenumber;
    
    @NotNull(message = "パスワードを入力してください")
    @Size(max =20,min =8,message ="８文字以上２０字以内で入力してください")
    private String password; 
    
    @NotNull(message = "役職を選択してください")
    private Long roleId;
    
    @NotNull(message = "店舗を選択してください")
    private Long storeId;
    
    @NotNull(message = "権限を選択してください")
    private Long authoritiesId;

    //以下getter・setter
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
    
    public String getPhonenumber() {
    	return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
    	this.phonenumber = phonenumber;
    }
    
    public String getPassword() {
    	return password; 
    }
    public void setPassword(String password) { 
    	this.password = password; 
    }
    
    public Long getRoleId() {
    	return roleId; 
    }
    public void setRoleId(Long roleId) { 
    	this.roleId = roleId; 
    }
    
    public Long getStoreId() { 
    	return storeId; 
    }
    public void setStoreId(Long storeId) {
    	this.storeId = storeId; 
    }
    
    public Long getAuthoritiesId() { 
    	return authoritiesId; 
    }
    public void setAuthoritiesId(Long authoritiesId) {
    	this.authoritiesId = authoritiesId; 
    }

}
