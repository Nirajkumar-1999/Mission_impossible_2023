package com.javaguides.employeeservice.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;




@Schema(
		description="OrganizationDto Model Information")
public class OrganizationDto {
	
	
	private long id;
	@Schema(
			description="Organization Name"
			)
	private String organizationName;
	@Schema(
			description="Organization Description"
			)
	private String organizationDescription;
	@Schema(
			description="Organization Code"
			)
	private String organizationCode;
	private LocalDateTime createdDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getOrganizationDescription() {
		return organizationDescription;
	}
	public void setOrganizationDescription(String organizationDescription) {
		this.organizationDescription = organizationDescription;
	}
	public String getOrganizationCode() {
		return organizationCode;
	}
	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public OrganizationDto(long id, String organizationName, String organizationDescription, String organizationCode,
			LocalDateTime createdDate) {
		super();
		this.id = id;
		this.organizationName = organizationName;
		this.organizationDescription = organizationDescription;
		this.organizationCode = organizationCode;
		this.createdDate = createdDate;
	}
	public OrganizationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
		
	
	
	

}