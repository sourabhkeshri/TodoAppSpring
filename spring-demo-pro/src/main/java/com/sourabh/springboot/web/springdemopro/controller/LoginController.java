package com.sourabh.springboot.web.springdemopro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sourabh.springboot.web.springdemopro.services.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	@Autowired
	LoginService service;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	
	public String loginMsg() {
		
		return "login";
	}
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	
	public String afterSubmit(@RequestParam String name, @RequestParam String password, ModelMap m) {
		if(!service.validateLogin(name, password)) {
			m.put("message","Opps! Invalid Creds..");
			return "login";
		}
			
		
		m.put("name",name);
		m.put("password",password);
		return "welcome";
	}
}
