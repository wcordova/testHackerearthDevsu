package com.devsu.hackerearth.backend.client.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client extends Person {

	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private boolean isActive;	

	public Client(String name, String dni, String gender, int age, String address, String phone, String password, boolean isActive) {
		super(name, dni, gender, age, address, phone);
		this.password = password;
		this.isActive = isActive;
	}

	public Client() {
		super();
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	
}
