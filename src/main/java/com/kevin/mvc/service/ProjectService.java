package com.kevin.mvc.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kevin.mvc.dto.ProjectDto;
import com.kevin.mvc.exception.EntityNotFoundException;



@Service
public class ProjectService {

		private List<ProjectDto> projects = new LinkedList<>();
		
		public ProjectService(){
			ProjectDto javaProject = this.createProject("Java Project", "This is a Java Project" );
			ProjectDto javascriptProject = this.createProject("Javascript Project", "This is a Javascript Project");
			ProjectDto htmlProject = this.createProject("HTML Project", "This is an HTML project");
			
			this.projects.addAll(Arrays.asList(new ProjectDto[]{javaProject, javascriptProject, htmlProject}));
		}
		
		public List<ProjectDto> findAll(){
			return this.projects;
		}
		
		public ProjectDto find(Long id) throws EntityNotFoundException{
			ProjectDto found;
			try {
				found = this.projects.stream().filter(p -> {
					return p.getId().equals(id);
				}).collect(Collectors.toList()).get(0);
			} catch (IndexOutOfBoundsException e) {
				found = null;
			} 
			
			if (found == null) {
	            throw new EntityNotFoundException("No to-entry found with id: " + id);
	        }
			
			return  found;		
			 
		}

		private ProjectDto createProject(String title, String description) {
			ProjectDto project = new ProjectDto();
			project.setName(title);
			project.setAuthorizedFunds(new BigDecimal("100000"));
			project.setAuthorizedHours(new BigDecimal("1000"));
			project.setId(1L);
			project.setSpecial(false);
			project.setType("multi");
			project.setYear("2015");
			project.setDescription(description);
			return project;
		}
		
		
		
}
