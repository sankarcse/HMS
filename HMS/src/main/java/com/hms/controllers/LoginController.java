package com.hms.controllers;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.hms.entities.LoginEntity;
import com.hms.services.LoginService;

@Controller
@RequestMapping(value = "/loginController")
public class LoginController {

	@Autowired
	private LoginService service;

	@GetMapping(value = "/login", produces = { "application/json" })
	@ResponseBody
	public String loginUser(@RequestParam(value = "userName") String email,
			@RequestParam("password") String password) throws JsonProcessingException {
		LoginEntity loginEntity = new LoginEntity(email, password);
		System.out.println(loginEntity.getClass());
		Map<String, String> map = new HashMap<String, String>();
		// JsonObject obj=new JsonObject();
		if ("valid".equals(service.loginUser(loginEntity))) {

			// obj.addProperty("validation", "valid");
			map.put("validation", "valid");
			 ObjectMapper objectMapper = new ObjectMapper();
			 String json=objectMapper.writeValueAsString(map);
			return json;
		} else {
			map.put("validation", "invalid");
			// obj.addProperty("validation", "valid");

			 ObjectMapper objectMapper = new ObjectMapper();
			 String json=objectMapper.writeValueAsString(map);
			return json;
		}
	}
}