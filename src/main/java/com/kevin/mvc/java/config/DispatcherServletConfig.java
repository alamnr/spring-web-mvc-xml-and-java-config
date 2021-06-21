package com.kevin.mvc.java.config;

import java.util.Locale;
import java.util.Properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.kevin.mvc.controllers")
@ComponentScan(basePackages = "com.kevin.mvc.exception.resolver")
@EnableWebMvc
public class DispatcherServletConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}

	/*@Bean
	public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
	
		Properties exceptionMappings = new Properties();
		exceptionMappings.put("com.spring.mvc.test.exception.TodoNotFoundException", "error/404");
		exceptionMappings.put("java.lang.Exception", "error/error");
		exceptionMappings.put("java.lang.RuntimeException", "error/error");
	
		simpleMappingExceptionResolver.setExceptionMappings(exceptionMappings);
	
		Properties statusCodes = new Properties();
	
		statusCodes.put("error/404", "404");    // Resource not found
		statusCodes.put("error/error", "500");  // Internal  server error 
		statusCodes.put("error/400", "400");	// Bad request
	
		simpleMappingExceptionResolver.setStatusCodes(statusCodes);
	
		return simpleMappingExceptionResolver;
	}*/

	@Bean("messageSource")
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:i18n/welcome");
		messageSource.setDefaultEncoding("UTF-8");
		// messageSource.setUseCodeAsDefaultMessage(false);
		return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver() {
		//CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		 SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.ENGLISH);
		
		return localeResolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		registry.addInterceptor(localeChangeInterceptor);
	}

}
