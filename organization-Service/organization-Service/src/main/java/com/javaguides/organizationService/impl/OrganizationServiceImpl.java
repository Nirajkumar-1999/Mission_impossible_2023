package com.javaguides.organizationService.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaguides.organizationService.dto.OrganizationDto;
import com.javaguides.organizationService.entity.Organization;
import com.javaguides.organizationService.mapper.OrganizationMapper;
import com.javaguides.organizationService.repository.OrganizationRepository;
import com.javaguides.organizationService.service.OrganizationService;

import lombok.AllArgsConstructor;


@Service
public class OrganizationServiceImpl implements OrganizationService {
	
	
	public OrganizationRepository organizationRepository;
	
	

	



	public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
		super();
		this.organizationRepository = organizationRepository;
	}







	@Override
	public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
		//convert organization Dto into jpa entity
		Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
		Organization savedOrganization=organizationRepository.save(organization);
		
		
		return OrganizationMapper.mapToOrganizationDto(savedOrganization);
	}







	@Override
	public OrganizationDto getOrganizationByCode(String organizationCode) {
		Organization organizatio = organizationRepository.findByOrganizationCode(organizationCode);
		
		return OrganizationMapper.mapToOrganizationDto(organizatio);
	}
	
	

	



	

}
