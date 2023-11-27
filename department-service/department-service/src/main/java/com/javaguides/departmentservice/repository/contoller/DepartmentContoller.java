package com.javaguides.departmentservice.repository.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaguides.departmentservice.dto.DepartmentDto;
import com.javaguides.departmentservice.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/department")
@Tag(
		name="Department Service - DEPARTMENTCONTROLLER",
		description="Department controller exposes Rest APIs for Department Service")
public class DepartmentContoller {
	
	private DepartmentService departmentService;

	public DepartmentContoller(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	
	//Build save Department Rest Api
	
	@PostMapping
	@Operation(
			summary="Save Department Rest API",
			description="Save Department  rest api is used to save department object in database"
			)
	@ApiResponse(
			responseCode="201",
			description="HTTP status 201 created"
			)
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
		
		DepartmentDto savedDepartment =departmentService.savedDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartment,HttpStatus.CREATED);
	}
	
	//Build Get Department Rest Api
	@GetMapping("{department-code}")
	@Operation(
			summary="Get Department Rest API",
			description="Get Department  Rest Api is used to get department object in database"
			)
	@ApiResponse(
			responseCode="20o",
			description="HTTP status 200 Success"
			)
	public ResponseEntity<DepartmentDto> getDeapartment(@PathVariable("department-code") String DepartmentCode){
		DepartmentDto departmentDto = departmentService.getDepartmentByCode(DepartmentCode);
		return new ResponseEntity<>(departmentDto,HttpStatus.OK);
	}
	
	
	
	

}
