package com.example.event_management.entity;

import jakarta.persistence.*;

@Entity // hibernate
@Table(name = "users") // db name 
public class User {

    @Id //primary key 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // automatically geneerates value for the id 
    private int id;
    private String name;
    private String email;
    private String password;
    private String role;
    
    // getter setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	} 
}

