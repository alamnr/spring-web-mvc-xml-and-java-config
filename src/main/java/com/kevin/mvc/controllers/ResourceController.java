package com.kevin.mvc.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kevin.mvc.dto.ResourceDto;

@Controller
@RequestMapping("/resource")
public class ResourceController {

	@RequestMapping("/add")
	public String add(Model model) {
		
		List<String> typeOptions = new LinkedList<>(Arrays.asList("Material","Other","Staff","Technical Equipment"));
		model.addAttribute("typeOptions", typeOptions);
		
		List<String> radios = new LinkedList<String>(Arrays.asList("Hours","Piece","Tons"));
		model.addAttribute("radios", radios);
		
		List<String> checks = new LinkedList<String>(Arrays.asList("Lead Time","Special Rate","Require Approval"));
		model.addAttribute("checks", checks);
		
		ResourceDto resourceDto = new  ResourceDto();
		resourceDto.setName("New Resource");
		resourceDto.setType(typeOptions.get(2)); 
		resourceDto.setUnitOfMeasure(radios.get(1));
		resourceDto.setIndicators(new String[] {checks.get(0),checks.get(2)});
		model.addAttribute("resource", resourceDto);
		
		
		return "resource/resource_add";
	}
	
	@RequestMapping("/save")
	public String save(@ModelAttribute ResourceDto resource,Model model) {
		System.out.println("Invoking save method");
		System.out.println(resource.toString());
		model.addAttribute("resource", new ResourceDto());
		return "resource/resource_add";
	}
}
