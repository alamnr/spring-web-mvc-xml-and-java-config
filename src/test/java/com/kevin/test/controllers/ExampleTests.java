package com.kevin.test.controllers;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.kevin.mvc.controllers.ProjectController;
import com.kevin.mvc.java.config.ApplicationConfig;
import com.kevin.mvc.java.config.DispatcherServletConfig;
import com.kevin.mvc.service.ProjectService;

import static org.hamcrest.Matchers.*;


@RunWith(SpringRunner.class)
@WebAppConfiguration
//@ContextConfiguration("classpath:test-servlet-context.xml")
//@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/dispatcher-servlet.xml")
@ContextConfiguration(classes = {DispatcherServletConfig.class, ApplicationConfig.class})
//@ExtendWith(MockitoExtension.class)
public class ExampleTests {
	
	@Autowired
	WebApplicationContext wac;
	
	@Autowired
    private MessageSource messageSource;
	
	/*@Mock
	private ProjectService projectService;*/
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void getHome() throws Exception {
		
		/*	MvcResult result =  this.mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andReturn();
		System.out.println("result : " + result.getResponse().getContentAsString());
		assertTrue("homeh".equalsIgnoreCase(result.getResponse().getContentAsString()));*/
		
		 this.mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("home"));
	}
	
	@Test
	public void showAddProjectForm_ShouldCreateFormObjectAndRenderAddProjectForm() throws Exception {
		mockMvc.perform(get("/project/add")).andExpect(status().isOk())
		.andExpect(view().name("project/project_add"))
		.andExpect(forwardedUrl("/WEB-INF/views/project/project_add.jsp"));
		/*.andExpect(model().attribute(ProjectController.MODEL_ATTRIBUTE, hasProperty("id", nullValue())))
		.andExpect(model().attribute(ProjectController.MODEL_ATTRIBUTE,
				hasProperty("description", isEmptyOrNullString())))
		.andExpect(model().attribute(ProjectController.MODEL_ATTRIBUTE,
				hasProperty("title", isEmptyOrNullString())));*/
		/*System.out.println(projectService);
		verifyNoMoreInteractions(projectService);*/
	}
	
	
    @Test
    public void messageSourceTest() {
        assertNotNull(messageSource);
        assertEquals("Project", messageSource.getMessage("label.project.view.page.title", null, Locale.ENGLISH));
    }
}
