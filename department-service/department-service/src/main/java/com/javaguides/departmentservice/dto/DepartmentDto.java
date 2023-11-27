package com.javaguides.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
		description="DepartmentDto Model Information")
public class DepartmentDto {
	
	private long id;
	@Schema(
			description="Department Name"
			)
	private String departmentName;
	@Schema(
			description="Department Description"
			)
	private String departmentDescription;
	@Schema(
			description="Department Code"
			)
	private String departmentCode;

}
