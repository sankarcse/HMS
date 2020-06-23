package com.hms.controllers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hms.entities.CustomersEntity;
import com.hms.services.CustomersService;

@RestController

@RequestMapping("/customersController")
public class CustomersController {

	@Autowired
	private CustomersService customersService;
	
	
/*	@GetMapping(value="/addCustomer",produces= {"applicaiton/json"})
	public String addCustomer(@RequestParam(value="firstName") String firstName,@RequestParam(value="lastName") String lastName,@RequestParam(value="joiningDate") String joiningDate,@RequestParam(value="email") String email,@RequestParam(value="phoneNumber") String phoneNumber,@RequestParam(value="adhaarNumber") String adhaarNumber,@RequestParam(value="profession") String profession,@RequestParam(value="workPlace") String workPlace,@RequestParam(value="homeTown") String homeTown,@RequestParam(value="district") String district,@RequestParam(value="state") String state,@RequestParam(value="pincode") String pincode) throws JsonProcessingException, ParseException {
		SimpleDateFormat  sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date joiningDate2=sdf.parse(joiningDate);
		CustomersEntity customersEntity=new CustomersEntity(firstName,lastName,joiningDate2,email,phoneNumber,adhaarNumber,profession,workPlace,homeTown,district,state,pincode);
		
		String customersEntity2=customersService.addCustomer(customersEntity);
		
		return customersEntity2;
		
	}
	*/
	
	

	
	@PostMapping(value="/addCustomer",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String addCustomer(@RequestBody CustomersEntity customersEntity) throws JsonProcessingException {
		
		String customersEntity2=customersService.addCustomer(customersEntity);
		
		return customersEntity2;
		
	}
	
	@GetMapping(value="/getAllCustomers",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAllCustomers() throws JsonProcessingException {
		
		String customersEntity2=customersService.getAllCustomers();
		return customersEntity2;
		
	}
	
	@PostMapping(value="/getserilaNumber",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getserilaNumber(@RequestBody CustomersEntity customersEntity) throws JsonProcessingException{
		
		String customersEntity2=customersService.getserilaNumber(customersEntity);
		return customersEntity2;
		
	}
	
	@PostMapping(value="/delCustomer",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String delCustomer(@RequestBody CustomersEntity customersEntity) throws JsonProcessingException{
		
		String customersEntity2=customersService.delCustomer(customersEntity);
		
		return customersEntity2;
		
	}
	
	
}
