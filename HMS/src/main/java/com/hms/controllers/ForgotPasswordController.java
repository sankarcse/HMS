package com.hms.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="/forgotPassword")
public class ForgotPasswordController {

	@PostMapping(value="/testUserName",produces={"application/json"})
	public String testUserName() {
		
		
		return null;
		
	}

}
