package com.kevin.mvc.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResourceDto {

	private Long id;
	private String name;
	private String type;
	private BigDecimal cost;
	private String unitOfMeasure;
	private String[] indicators;
	private String notes;
}
