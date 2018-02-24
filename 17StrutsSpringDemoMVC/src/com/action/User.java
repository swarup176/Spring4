package com.action;



public class User {

	private Long id;
	private String name;
	private String password;
	private String gender;
	private String country;
	
	

	public User(String userID,String userPass){
	
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
	

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
