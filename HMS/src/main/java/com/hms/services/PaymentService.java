package com.hms.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hms.entities.PaymentEntity;
import com.hms.repositories.PaymentRepo;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepo paymentRepo;
	
	public String doPayment(PaymentEntity paymentEntity) throws JsonProcessingException {

		Map<String, String> map = new HashMap<String, String>();
		ObjectMapper objectMapper = new ObjectMapper();
		
		
			PaymentEntity p=paymentRepo.save(paymentEntity);
			if(p!=null) {
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
}
