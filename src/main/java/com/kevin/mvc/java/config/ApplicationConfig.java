package com.kevin.mvc.java.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
//@EnableJpaRepositories("com.telusko.domain")
//@EnableTransactionManagement
@ComponentScan(basePackageClasses = {  })
//@EnableJpaAuditing(auditorAwareRef = "customAuditorAware")
public class ApplicationConfig {

}
