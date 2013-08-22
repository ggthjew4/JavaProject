package com.bt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String root(ModelMap model) {
		model.addAttribute("message", "Spring Security Hello World");
		return "index";
	}
	
	@RequestMapping(value = "/ssoLogin", method = RequestMethod.GET)
	public String ssoLogin(ModelMap model) {
		return "ssoLogin";
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("message", "Spring Security Hello World");
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(ModelMap model) {
		return "accessDenied";
	}
	
	@RequestMapping(value = "/expire", method = RequestMethod.GET)
	public String expire(ModelMap model) {
		return "expire";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "login";
	}
	
	
}
