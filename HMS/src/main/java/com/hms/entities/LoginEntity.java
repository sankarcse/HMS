package com.hms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "admin_users")
public class LoginEntity {
	
	public LoginEntity() {}
	public  LoginEntity(String email,String password) {
		this.userName=email;
		this.userPassword=password;
	}
	

	@Id
	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_password")
	private String userPassword;
	
	
	private String email;
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	

}
