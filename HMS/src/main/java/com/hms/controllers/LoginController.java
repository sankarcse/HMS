package com.hms.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hms.entities.LoginEntity;
import com.hms.services.LoginService;

@Controller
@RequestMapping(value = "/loginController")
public class LoginController {

	@Autowired
	private LoginService service;

	@PostMapping(value = "/login", produces = "application/json")
	@ResponseBody
	public Map<String,String> loginUser(@RequestParam(value = "userName") String email,
			@RequestParam("password") String password) {
		LoginEntity loginEntity=new LoginEntity(email,password);
		System.out.println(loginEntity.getClass());
		Map<String,String> map=new HashMap<String,String>();
		if ("valid".equals(service.loginUser(loginEntity))) {
			
			
			map.put("validation", "valid");
			return map;
		} else {
			map.put("validation", "invalid");
			return map;
		}
	}
}
