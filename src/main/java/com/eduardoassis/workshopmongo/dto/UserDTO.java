package com.eduardoassis.workshopmongo.dto;

import java.io.Serializable;

import com.eduardoassis.workshopmongo.domain.User;

public class UserDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	private String address;
	private String dateOfBirth;
	private String age;
	private String countryOfBirth;
	
	public UserDTO() {
		
	}
	
	

	public UserDTO(User obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
		this.address = obj.getAddress();
		this.dateOfBirth = obj.getDateOfBirth();
		this.age = obj.getAge();
		this.countryOfBirth = obj.getCountryOfBirth();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name.toUpperCase();
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCountryOfBirth() {
		return countryOfBirth;
	}

	public void setCountryOfBirth(String countryOfBirth) {
		this.countryOfBirth = countryOfBirth;
	}
	
}
