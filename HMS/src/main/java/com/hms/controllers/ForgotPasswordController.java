package com.hms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hms.entities.LoginEntity;
import com.hms.entities.UserVerification;
import com.hms.repositories.UserVerificationRepo;
import com.hms.services.ForgotPasswordService;
@RestController
@RequestMapping(value="/forgotPassword")
public class ForgotPasswordController {

	@Autowired
	private ForgotPasswordService service;
	
	
	@GetMapping(value="/testUserName",produces={"application/json"})
	public String testUserName(@RequestParam(value="userName") String userName) throws JsonProcessingException {
		LoginEntity loginEntity = new LoginEntity(userName,"");
		String validation=service.testUserName(loginEntity);
		return validation;
	}
	
	
	@GetMapping(value="/sendingMailUtil",produces={"application/json"})
	public String sendMailUtil(@RequestParam(value="userName") String userName) throws JsonProcessingException {
		LoginEntity loginEntity = new LoginEntity(userName,"");
		String confirmation=service.sendMailUtil(loginEntity);
		return confirmation;
	}
	
	@GetMapping(value="/changePassword",produces={"application/json"})
	public String changePassword(@RequestParam(value="code") String code,@RequestParam(value="userName") String userName) throws JsonProcessingException {
		UserVerification userVerification=new UserVerification(userName);
		
		String validation=service.changePassword(code,userVerification);
		return validation;
	}

	@GetMapping(value="/newPassword",produces={"application/json"})
	public String newPassword(@RequestParam(value="userName") String userName,@RequestParam(value="newPass") String newPass) throws JsonProcessingException {
		LoginEntity loginEntity=new LoginEntity(userName, newPass);
		
		String validation=service.updatePassword(loginEntity);
		return validation;
	}
	

	
}
