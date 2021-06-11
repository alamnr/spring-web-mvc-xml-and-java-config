package com.kevin.mvc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("/add")
	public String addProject() {
		return "project/project_add"; 
	}

	

}
