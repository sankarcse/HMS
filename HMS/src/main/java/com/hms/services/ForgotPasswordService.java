package com.hms.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hms.entities.LoginEntity;
import com.hms.repositories.LoginRepo;

@Service
public class ForgotPasswordService {

	@Autowired
	private LoginRepo repository;
	
	public String testUserName(LoginEntity loginEntity) throws JsonProcessingException {
		
		Map<String, String> map = new HashMap<String, String>();
		ObjectMapper objectMapper = new ObjectMapper();
		LoginEntity user=repository.findByUserName(loginEntity.getUserName());
		if (user!=null){
			
			 map.put("validation", "valid");
			 String json=objectMapper.writeValueAsString(map);
			
			return json;
			
		} else {
			 map.put("validation", "invalid");
			 String json=objectMapper.writeValueAsString(map);
			
			return json;
		}
	}

}
