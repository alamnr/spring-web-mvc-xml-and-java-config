package com.kevin.mvc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String home() {
		LOGGER.info("inside home controller");
		System.out.println("here i am");
		return "home"; 
	}
	
}
