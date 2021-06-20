package com.kevin.mvc.dto;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class ProjectDto {
	
	private Long id;
	
	private String name;
	
	private String type;
	
	private Sponsor sponsor;
	
	private BigDecimal authorizedHours;
	
	private BigDecimal authorizedFunds;
	
	@NotBlank(message = "Description must not empty")
	private String description;	
	
	private boolean special;
	
	private String year;	
	
	private List<String> pointsOfContact; 

}
