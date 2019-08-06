package com.example.pjmall.backend.domain;

public class User {
	private Long no;
	private String email;
	private String password;
	
	public User() {
	}
	
	public User(Long no, String email, String password) {
		this.no = no;
		this.email = email;
		this.password = password;
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
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
	
	
}
