package com.kevin.mvc.controllers;

import java.net.Authenticator.RequestorType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kevin.mvc.dto.ProjectDto;
import com.kevin.mvc.exception.EntityNotFoundException;
import com.kevin.mvc.service.ProjectService;

@Controller
@RequestMapping("/project")
public class ProjectController {
	 
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);
	
	protected static final String FEEDBACK_MESSAGE_KEY_ADDED = "feedback.message.added";
	protected static final String FEEDBACK_MESSAGE_KEY_UPDATED = "feedback.message.updated";
	protected static final String FEEDBACK_MESSAGE_KEY_DELETED = "feedback.message.deleted";
	protected static final String FLASH_MESSAGE_KEY_FEEDBACK = "feedbackMessage";

	protected static final String MODEL_ATTRIBUTE = "project";
	protected static final String MODEL_ATTRIBUTE_LIST = "projects";

	protected static final String PARAMETER_ID = "id";

	protected static final String REQUEST_MAPPING_LIST = "/projects";
	protected static final String REQUEST_MAPPING_VIEW = "/project/{id}";

	protected static final String VIEW_ADD = "project/project_add";
	protected static final String VIEW_LIST = "project/project_list";
	protected static final String VIEW_UPDATE = "project/project_update";
	protected static final String VIEW_DETAIL = "project/project_details";
	
	private final ProjectService projectService;
	
	private final MessageSource messageSource;
	
	@Autowired
	public ProjectController(ProjectService projectService, MessageSource messageSource) {
		super();
		this.projectService = projectService;
		this.messageSource = messageSource; 
	}
	
	@RequestMapping(value = "/{id}")
	public String findOne(@PathVariable Long id,Model model) throws EntityNotFoundException {
		model.addAttribute(MODEL_ATTRIBUTE, this.projectService.find(id));
		return "project/project";
	}
	
	@RequestMapping(value = "/find")
	public String findAll(Model model) {
		model.addAttribute(MODEL_ATTRIBUTE_LIST, this.projectService.findAll());
		return "project/projects";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProject(Model model) {
		LOGGER.info("invoking add project");
		System.out.println("Invoking add project");
		List<String> types = new ArrayList<>(Arrays.asList("Single Year","Multi Year"));
		model.addAttribute("types", types);
		model.addAttribute(MODEL_ATTRIBUTE, new ProjectDto());
		
		return "project/project_add"; 
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveProject(@ModelAttribute ProjectDto project,Model model) {
		LOGGER.info("invoking save project");
		System.out.println("Invoking save project");
		System.out.println(project); 
		model.addAttribute(MODEL_ATTRIBUTE, new ProjectDto());
		
		return "redirect:project/add";
	}

	/*@RequestMapping(value = "/add" , method = RequestMethod.POST, params = {"type=multi"})
	public String saveMultiProject() {
		LOGGER.info("save multi project");
		System.out.println("Save multi project");
		return "project/project_add";
	}
	
	@RequestMapping(value = "/add" , method = RequestMethod.POST,params = {"type=multi","special"})
	public String saveMultiSpecialProject() {
		LOGGER.info("save multi special project");
		System.out.println("save multi special project");
		return "project/project_add";
	}*/

}
