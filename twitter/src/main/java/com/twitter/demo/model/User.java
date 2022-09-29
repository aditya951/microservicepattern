package com.twitter.demo.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection= "user")
public class User {
	
	@Id
	private String id;
	
	private String firstName;
	private String lastName;
	private String email;
	private String contactNo;
	private String password;
	private String username;
	private String profileImage;
	
	public User() {
		
	}
	
	
	

	public User(String id, String firstName, String lastName, String email, String contactNo, String password,
			String username, String profileImage) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactNo = contactNo;
		this.password = password;
		this.username = username;
		this.profileImage = profileImage;
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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getProfileImage() {
		return profileImage;
	}


	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	
	
	
	
			

}
