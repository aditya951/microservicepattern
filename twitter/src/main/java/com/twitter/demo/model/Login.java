package com.twitter.demo.model;

public class Login {

	private String password;
	private String username;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(String password, String username) {
		super();
		this.password = password;
		this.username = username;
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

}
