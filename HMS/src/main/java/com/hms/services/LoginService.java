package com.hms.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.controllers.SpringBootSessionController;
import com.hms.entities.LoginEntity;
import com.hms.repositories.LoginRepo;

@Service
public class LoginService {

	private static final HttpServletRequest HttpServletRequest = null;
	@Autowired
	private LoginRepo repository;

	public String loginUser(LoginEntity loginEntity) {
		LoginEntity user=repository.findByUserNameAndUserPassword(loginEntity.getUserName(),loginEntity.getUserPassword());

		if (user!=null){
			SpringBootSessionController a=new SpringBootSessionController();
			
			return "valid";
		} else
			return "invalid";
	}
}