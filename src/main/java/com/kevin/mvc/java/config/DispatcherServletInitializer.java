package com.kevin.mvc.java.config;

import javax.servlet.Filter;

import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



public class DispatcherServletInitializer {//extends AbstractAnnotationConfigDispatcherServletInitializer {

	/*@Override
	protected Class<?>[] getRootConfigClasses() {
	
		return new Class[] { ApplicationConfig.class};
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {DispatcherServletConfig.class};
	}
	
	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		// TODO for filter
		//return new Filter[] {new DelegatingFilterProxy("springSecurityFilterChain")};
		return null;
	}
	*/
}
