package com.bitcamp.op.vo;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private String username;
	private String password;
	private List<String> roles;
	
	public Account() {
		// TODO Auto-generated constructor stub
		roles = new ArrayList<String>();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getRole() {
		return roles;
	}
	public void addRole(String role) {
		this.roles.add(role);
	}

}
