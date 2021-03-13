package com.to;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class Client {
	@Id
	@Column(name= "username", unique = true)
	private String userName;
	@Column(name = "password")
	private String password;
	
	public Client() {
		super();
	}
	public Client(String userName, String password) {
		super();
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
}
