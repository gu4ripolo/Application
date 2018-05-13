package com.devops.webservice.model;

public class UserCredentials {

	private String name;
	private String password;

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

	public UserCredentials(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public UserCredentials() {

	}

}
