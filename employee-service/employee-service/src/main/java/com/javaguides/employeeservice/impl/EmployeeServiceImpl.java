package com.javaguides.employeeservice.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.javaguides.employeeservice.dto.APIResponseDto;
import com.javaguides.employeeservice.dto.DepartmentDto;
import com.javaguides.employeeservice.dto.EmployeeDto;
import com.javaguides.employeeservice.entity.Employee;
import com.javaguides.employeeservice.repository.EmployeeRepository;
import com.javaguides.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
//	private RestTemplate restTemplate;
	
	private WebClient webClient;
	
	
	

//	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//		super();
//		this.employeeRepository = employeeRepository;
//	}



	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		//convert EmployeeDto into jpa entity
		Employee employee = new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail(),
				employeeDto.getDepartmentCode()
				);
		
		Employee savedEmployee =employeeRepository.save(employee);
		
		//convert savedEmployee jpa entity into dto
		
		EmployeeDto saveDEmployeeDto = new EmployeeDto(
				savedEmployee.getId(),
				savedEmployee.getFirstName(),
				savedEmployee.getLastName(),
				savedEmployee.getEmail(),
				savedEmployee.getDepartmentCode()
				);
				
		return saveDEmployeeDto;
	}



	@Override
	public APIResponseDto getEmployeeById(long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();
		
//	    ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/department/" + employee.getDepartmentCode(),DepartmentDto.class);
//	    
//	    DepartmentDto departmentDto = responseEntity.getBody();
		
		DepartmentDto departmentDto =webClient.get().uri("http://localhost:8080/api/department/" + employee.getDepartmentCode())
		.retrieve().bodyToMono(DepartmentDto.class).block();
	    
		EmployeeDto employeeDto = new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getDepartmentCode()
				);
		
		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setEmployee(employeeDto);
		apiResponseDto.setDepartment(departmentDto);
		
		return apiResponseDto;
	}

}
