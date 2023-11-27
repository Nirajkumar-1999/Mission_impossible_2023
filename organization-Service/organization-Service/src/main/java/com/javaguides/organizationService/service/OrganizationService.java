package com.javaguides.organizationService.service;

import com.javaguides.organizationService.dto.OrganizationDto;

public interface OrganizationService {
	
	OrganizationDto saveOrganization(OrganizationDto organizationDto);
	
	OrganizationDto getOrganizationByCode(String organizationCode);

}
