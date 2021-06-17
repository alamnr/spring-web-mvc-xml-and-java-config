package com.kevin.mvc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kevin.mvc.dto.ProjectDto;

@Controller
public class HomeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	public String home(Model model) {
		LOGGER.info("inside home controller");
		ProjectDto project = new ProjectDto();
		project.setName("First Project");
		
		project.setDescription("Simple project sponsored by gasa");
		
		model.addAttribute("currentProject", project);
		
		return "home"; 
	}
	
}
