package com.example.sample.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class User {
    @Id
	public int user_id;
    
    @Column
    public String name;
    
    @Column
    public String email;
    
    @Column
    public String status;
    
    @Column(nullable = false, updatable = false) 
    private LocalDateTime createdAt = LocalDateTime.now();

	public User(int user_id, String name, String email, String status, LocalDateTime createdAt) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.status = status;
		this.createdAt = createdAt;
	}
 public User() {
	// TODO Auto-generated constructor stub
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public LocalDateTime getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
}
}
