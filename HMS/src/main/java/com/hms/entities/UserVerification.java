package com.hms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_verification")
public class UserVerification {

	@Id
	@Column(name="user_name")
	private String userName;
	@Column(name="verification_code")
	private String verificationCode;
	
	public UserVerification() {}
	public UserVerification(String userName2, String code) {
		this.userName=userName2;
		this.verificationCode=code;
	}
	public UserVerification(String userName2) {
		this.userName=userName2;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

}
