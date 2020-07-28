package com.app.api.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.*;

@Document
public class Login {
	
	@Transient
    public static final String SEQUENCE_NAME = "login_sequence";
 
	@Id
	private long id;

	private String email;
	private long mobileNumber;	
	private String password;
		
	public Login(long id, String email, long mobileNumber, String password) {
		super();
		this.id = id;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "login [id=" + id + ", email=" + email + ", mobileNumber=" + mobileNumber + ", password=" + password
				+ "]";
	}
}
