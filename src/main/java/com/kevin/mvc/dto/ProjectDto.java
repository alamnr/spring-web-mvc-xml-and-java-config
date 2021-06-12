package com.kevin.mvc.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class ProjectDto {
	
	private Long id;
	
	private String name;
	
	private String type;
	
	private String sponsor;
	
	private BigDecimal authorizedHours;
	
	private BigDecimal authorizedFunds;
	
	private String description;	
	
	private boolean special;
	
	private String year;	

}
