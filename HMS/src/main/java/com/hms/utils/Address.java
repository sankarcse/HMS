package com.hms.utils;

public class Address {
	private static int pincode;
	private static String city;
	private static String state;
	private static String country;
	
	public Address(String city,int pincode,String state,String country) {
		this.city=city;
		this.pincode=pincode;
		this.state=state;
		this.country=country;

	}
}
