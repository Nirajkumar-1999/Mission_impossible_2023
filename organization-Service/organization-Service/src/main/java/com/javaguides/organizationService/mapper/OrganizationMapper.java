package com.javaguides.organizationService.mapper;

import com.javaguides.organizationService.dto.OrganizationDto;
import com.javaguides.organizationService.entity.Organization;

public class OrganizationMapper {
	
	//convert organization jap entity into organization dto
	public static OrganizationDto mapToOrganizationDto(Organization organization) {
		OrganizationDto organizationDto = new OrganizationDto(
				organization.getId(),
				organization.getOrganizationName(),
				organization.getOrganizationDescription(),
				organization.getOrganizationCode(),
				organization.getCreatedDate()
				);
		
		return organizationDto;
	}
	
	//convert organization dto into organization jpa entity
	
	public static Organization mapToOrganization(OrganizationDto organizatioDto) {
		Organization organization = new Organization(
				organizatioDto.getId(),
				organizatioDto.getOrganizationName(),
				organizatioDto.getOrganizationDescription(),
				organizatioDto.getOrganizationCode(),
				organizatioDto.getCreatedDate()
				);
		return organization;
	}

}
