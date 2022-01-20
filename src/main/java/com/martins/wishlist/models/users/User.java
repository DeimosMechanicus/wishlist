package com.martins.wishlist.models.users;

public class User {
	
	String type;
	Long id;
	String name;
	String email;
	
	public User(String type, Long id, String name, String email) {
		super();
		this.type = type;
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	
	
}
