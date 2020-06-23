package com.hms.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="payment_table")
public class PaymentEntity {

	public PaymentEntity() {
		// TODO Auto-generated constructor stub
	}


	private String firstName;
	private String lastName;
	private String joiningDate;
	private String email;
	private String phoneNumber;
	private String roomNumber;
	@Id
	private String adharCardNumber;
	private String sharingType;
	
	private int actualFee;
	private int payingNow;

	/*private int oldBalance;
	private int advanceAmount;*/
	
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSharingType() {
		return sharingType;
	}
	public void setSharingType(String sharingType) {
		this.sharingType = sharingType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdharCardNumber() {
		return adharCardNumber;
	}
	public void setAdharCardNumber(String adharCardNumber) {
		this.adharCardNumber = adharCardNumber;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getActualFee() {
		return actualFee;
	}
	public void setActualFee(String actualFee) {
		this.actualFee = Integer.parseInt(actualFee);
	}
	
	
	public int getPayingNow() {
		return payingNow;
	}
	public void setPayingNow(String payingNow) {
		this.payingNow = Integer.parseInt(payingNow);
	}
	

}
