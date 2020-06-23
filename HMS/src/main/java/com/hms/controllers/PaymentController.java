package com.hms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hms.entities.PaymentEntity;
import com.hms.services.PaymentService;


@RequestMapping(value="/paymentController")
@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	
	@PostMapping(value="/doPayment",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public String doPayment(@RequestBody PaymentEntity paymentEntity) throws JsonProcessingException {
		System.out.println(paymentEntity.getActualFee());
		int a=paymentEntity.getActualFee();
		
		
		String validation=paymentService.doPayment(paymentEntity);
		return validation;
	}

}
