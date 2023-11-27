package com.javaguides.organizationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaguides.organizationService.entity.Organization;



public interface OrganizationRepository extends JpaRepository<Organization, Long> {
	
	Organization findByOrganizationCode(String organizationCode);

}
