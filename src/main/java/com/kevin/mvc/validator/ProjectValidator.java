package com.kevin.mvc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.kevin.mvc.dto.ProjectDto;

public class ProjectValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return ProjectDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ProjectDto projectDto = (ProjectDto)target;
		if(projectDto.getName().length()<5) {
			errors.rejectValue("name", "Project.validator.name", "Project name is too short");
		}
	}

}
