package com.apusic.ecc.entity;

import org.springframework.data.annotation.Id;

public class User {

	@Id
	private String id;
	private String userName;
	private String password;
	
	public User(){
		
	}
	
	public User(String userName, String password){
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format("User[id=%s, userName='%s', password='%s']", id,
				userName, password);
}
}
