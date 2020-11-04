package com.sourabh.springboot.web.springdemopro.services;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	public boolean validateLogin(String id, String password) {
		if(id.equalsIgnoreCase("sourabh") && password.equals("123"))
			return true;
		if(id.equalsIgnoreCase("gaurav") && password.equals("123"))
			return true;
		return false;
		
	}

}
