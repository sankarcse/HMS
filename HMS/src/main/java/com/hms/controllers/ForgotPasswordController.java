package com.hms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hms.entities.LoginEntity;
import com.hms.services.ForgotPasswordService;

@RestController(value="/forgotPassword")
public class ForgotPasswordController {

	@Autowired
	private ForgotPasswordService service;
	
	
	@GetMapping(value="/testUserName",produces={"application/json"})
	public String testUserName(@RequestParam(value="userName") String userName) throws JsonProcessingException {
		LoginEntity loginEntity = new LoginEntity(userName,"");
		String validation=service.testUserName(loginEntity);
		return validation;
	}

}
