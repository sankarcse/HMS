package com.hms.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hms.entities.LoginEntity;
import com.hms.services.LoginService;
import com.hms.utils.SendMail;

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
		
		Map<String, String> map = new HashMap<String, String>();
		
		if ("valid".equals(service.loginUser(loginEntity))) {
			map.put("validation", "valid");
			//new SendMail().sendMail("sankarcse05@gmail.com", "login success", "Hi Sankar,\r\t\t you are logged into hms");
			 ObjectMapper objectMapper = new ObjectMapper();
			 String json=objectMapper.writeValueAsString(map);
			return json;
		} else {
			map.put("validation", "invalid");
			 ObjectMapper objectMapper = new ObjectMapper();
			 String json=objectMapper.writeValueAsString(map);
			return json;
		}
	}
}