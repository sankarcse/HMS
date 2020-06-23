package com.hms.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="customers_table")
public class CustomersEntity {

	public CustomersEntity() {
		
	}
	public Integer getSno() {
		return sno;
	}
	public void setSno(Integer sno) {
		this.sno = sno;
	}
	@Column(name="sno")
	private Integer sno;
	private String firstName;
	private String lastName;
	private Date joiningDate;
	private String email;
	private String phoneNumber;
	@Id
	private String adharCardNumber;
	private String homeTown;
	private String district;
	private String state;
	private String country;
	private String pincode;
	private String workPlace;
	private String profession;
	private String roomNumber;
	private String sharingType;
	
	public String getSharingType() {
		return sharingType;
	}
	public void setSharingType(String sharingType) {
		this.sharingType = sharingType;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return sno+". "+firstName;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAdharCardNumber() {
		return adharCardNumber;
	}
	public void setAdharCardNumber(String adharCardNumber) {
		this.adharCardNumber = adharCardNumber;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
}
