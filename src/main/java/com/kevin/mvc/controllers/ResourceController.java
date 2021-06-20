package com.kevin.mvc.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kevin.mvc.dto.ResourceDto;
import com.kevin.mvc.service.ProjectService;

@Controller
@RequestMapping("/resource")
@SessionAttributes("resource")
public class ResourceController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ResourceController.class);
	
	protected static final String FEEDBACK_MESSAGE_KEY_ADDED = "feedback.message.added";
	protected static final String FEEDBACK_MESSAGE_KEY_UPDATED = "feedback.message.updated";
	protected static final String FEEDBACK_MESSAGE_KEY_DELETED = "feedback.message.deleted";
	protected static final String FLASH_MESSAGE_KEY_FEEDBACK = "feedbackMessage";

	protected static final String MODEL_ATTRIBUTE = "resource";
	protected static final String MODEL_ATTRIBUTE_LIST = "resources";

	protected static final String PARAMETER_ID = "id";

	protected static final String REQUEST_MAPPING_LIST = "/resources";
	protected static final String REQUEST_MAPPING_VIEW = "/resource/{id}";

	protected static final String VIEW_ADD = "resource/resource_add";
	protected static final String VIEW_LIST = "resource/resource_list";
	protected static final String VIEW_UPDATE = "resource/resource_update";
	protected static final String VIEW_DETAIL = "resource/resource_details";
	
	//private final ProjectService projectService;
	
	private final MessageSource messageSource;
	
	
	@Autowired
	public ResourceController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

	@RequestMapping("/add")
	public String add() {
		System.out.println("Invoking add()");
		return "resource/resource_add";
	}
	
	@RequestMapping("/review")
	public String review(@ModelAttribute("resource") ResourceDto resource,HttpSession session) {
		System.out.println("Invoking review()");
		System.out.println(resource.toString());
		
		Enumeration<String> attributes = session.getAttributeNames();
		while (attributes.hasMoreElements()) {
		    String attribute = (String) attributes.nextElement();
		    System.out.println(attribute+" : "+session.getAttribute(attribute));
		}
		return "resource/resource_review";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute("resource") ResourceDto resource,SessionStatus status) {
		System.out.println("Invoking save() ");
		System.out.println(resource.toString());
		status.setComplete();
		return "redirect:/resource/add";
	}
	
	@RequestMapping("/request")
	@ResponseBody
	//public String request(@ModelAttribute("resource") ResourceDto resource) {
	//public String request(@RequestBody String resource) {
	public String request(@RequestBody ResourceDto resource) {
		System.out.println("Invoking request()");
		System.out.println(resource.toString()); 
		//System.out.println(resource);
		return "The request has been sent for approval. ";
	}
	
	@ModelAttribute("resource")
	public ResourceDto getResource() {
		System.out.println("Adding a new resource to the model");
		ResourceDto resourceDto = new  ResourceDto();
		//resourceDto.setName("New Resource");
		/*resourceDto.setType(getTypes().get(2)); 
		resourceDto.setUnitOfMeasure(getRadios().get(1));
		resourceDto.setIndicators(new String[] {getChecks().get(0),getChecks().get(2)});*/
		return resourceDto;
	}
	
	@ModelAttribute("typeOptions")
	public List<String> getTypes(){
		return new LinkedList<>(Arrays.asList("Material","Other","Staff","Technical Equipment"));
	}
	
	@ModelAttribute("radios")
	public  List<String>  getRadios(){
		return new LinkedList<String>(Arrays.asList("Hours","Piece","Tons"));
	}
	
	@ModelAttribute("checks")
	public List<String> getChecks(){
		return new LinkedList<String>(Arrays.asList("Lead Time","Special Rate","Require Approval"));
	}
}
