package com.devsu.hackerearth.backend.client.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person extends Base {

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String dni;

	@Column(nullable = false)
	private String gender;

	@Column(nullable = false)
	private int age;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String phone;	
	
	public Person() {
	}

	public Person(String name, String dni, String gender, int age, String address, String phone) {
		this.name = name;
		this.dni = dni;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
}
