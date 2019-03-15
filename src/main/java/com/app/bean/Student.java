package com.app.bean;

public class Student {

	private String uno;
	private String name;
	private Gender gender;
	private String emailAddress;
	
	
	public Student(String uno, String name, Gender gender) {
		super();
		this.uno = uno;
		this.name = name;
		this.gender = gender;
	}
	
	public String getUno() {
		return uno;
	}
	public void setUno(String uno) {
		this.uno = uno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
	
}
