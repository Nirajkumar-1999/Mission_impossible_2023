package com.javaguides.employeeservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaguides.employeeservice.dto.APIResponseDto;
import com.javaguides.employeeservice.dto.EmployeeDto;
import com.javaguides.employeeservice.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping
	@Operation(
			summary="Save Employee Rest API",
			description="Save Employee  Rest Api is used to save employee object in database"
			)
	@ApiResponse(
			responseCode="201",
			description="HTTP status 201 created"
			)
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
		
	}
	
	//Build getById Empl Rest Api
	
	@GetMapping("{id}")
	@Operation(
			summary="Get Employee Rest API",
			description="Get Employee  Rest Api is used to get employee object in database"
			)
	@ApiResponse(
			responseCode="200",
			description="HTTP status 200 success"
			)
	public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") long employeeId){
		APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
	}

}
