package com.hms.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.hms.entities.CustomersEntity;
import com.hms.repositories.CustomersRepo;

@Service
public class CustomersService {

	@Autowired
	private CustomersRepo customersRepo;
	
	public String addCustomer(CustomersEntity customersEntity) throws JsonProcessingException {
		Map<String, String> map = new HashMap<String, String>();
		ObjectMapper objectMapper = new ObjectMapper();
		Object customersEntity2=customersRepo.findById(customersEntity.getAdharCardNumber());
		if(customersEntity2==Optional.empty()) {
			customersRepo.save(customersEntity);
			map.put("validation", "valid");
			String json = objectMapper.writeValueAsString(map);
			return json;
		}
		else{
			map.put("validation", "invalid");
			String json = objectMapper.writeValueAsString(map);
			return json;
		}
	}

	public String getAllCustomers() throws JsonProcessingException {
		ArrayList<CustomersEntity> allCustomers=(ArrayList<CustomersEntity>) customersRepo.findAll();
	
		return  new Gson().toJson(allCustomers);
	}

	public String getserilaNumber(CustomersEntity customersEntity) throws JsonProcessingException{
		CustomersEntity customersEntity1=customersRepo.findBySno(customersEntity.getSno());
		return new Gson().toJson(customersEntity1);
	}

	public String delCustomer(CustomersEntity customersEntity) throws JsonProcessingException {
		CustomersEntity customersEntity1=customersRepo.findBySno(customersEntity.getSno());
		String status="";
		if(customersEntity1 !=null) {
			customersRepo.delete(customersEntity1);
			status="success";
			
		}
		Map<String, String> map = new HashMap<String, String>();
		ObjectMapper objectMapper = new ObjectMapper();
		
		if("success".equalsIgnoreCase(status)) {
			map.put("status", "success");
			String json = objectMapper.writeValueAsString(map);
			return json;
		}
		
		else
		{
			
			map.put("status", "failure");
			String json = objectMapper.writeValueAsString(map);
			return json;
		}
	}


	
}
