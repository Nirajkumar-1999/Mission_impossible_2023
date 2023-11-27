package com.javaguides.organizationService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaguides.organizationService.dto.OrganizationDto;
import com.javaguides.organizationService.service.OrganizationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/organization")
@Tag(
		name="Organization Service - ORGANIZATIONCONTROLLER",
		description="Organization controller exposes Rest APIs for Organization Service")
public class OrganizationController {
	
	private OrganizationService organizationService;
	
	
	
	public OrganizationController(OrganizationService organizationService) {
		super();
		this.organizationService = organizationService;
	}



	//Build save Organization Api
	@PostMapping
	@Operation(
			summary="Save Organization Rest API",
			description="Save Organization  Rest Api is used to save organization object in database"
			)
	@ApiResponse(
			responseCode="201",
			description="HTTP status 201 created"
			)
	public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
		OrganizationDto savedOrganizationDto=organizationService.saveOrganization(organizationDto);
		return new ResponseEntity<>(savedOrganizationDto,HttpStatus.CREATED);
	}
	
	
	
	//Build get organization By organization code 
	@GetMapping("{code}")
	@Operation(
			summary="Get Organization Rest API",
			description="Get Organization  Rest Api is used to get organization object in database"
			)
	@ApiResponse(
			responseCode="200",
			description="HTTP status 200 success"
			)
	public ResponseEntity<OrganizationDto> getOrganization(@PathVariable("code") String organizationCode){
		
		OrganizationDto organizationDto=organizationService.getOrganizationByCode(organizationCode);
		
		return new ResponseEntity<>(organizationDto,HttpStatus.OK);
		
	}

}
