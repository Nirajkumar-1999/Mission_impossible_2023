package com.javaguides.employeeservice.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.javaguides.employeeservice.dto.APIResponseDto;
import com.javaguides.employeeservice.dto.DepartmentDto;
import com.javaguides.employeeservice.dto.EmployeeDto;
import com.javaguides.employeeservice.dto.OrganizationDto;
import com.javaguides.employeeservice.entity.Employee;
import com.javaguides.employeeservice.mapper.EmployeeMapper;
import com.javaguides.employeeservice.repository.EmployeeRepository;

import com.javaguides.employeeservice.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
//	private RestTemplate restTemplate;
	
	private WebClient webClient;
	
//	private APIClient apiClient;
	
	
	

//	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
//		super();
//		this.employeeRepository = employeeRepository;
//	}



	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		//convert EmployeeDto into jpa entity
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		
//		Employee employee = new Employee(
//				employeeDto.getId(),
//				employeeDto.getFirstName(),
//				employeeDto.getLastName(),
//				employeeDto.getEmail(),
//				employeeDto.getDepartmentCode()
//				);
//		
		Employee savedEmployee =employeeRepository.save(employee);
		
		//convert savedEmployee jpa entity into dto
		
//		EmployeeDto saveDEmployeeDto = new EmployeeDto(
//				savedEmployee.getId(),
//				savedEmployee.getFirstName(),
//				savedEmployee.getLastName(),
//				savedEmployee.getEmail(),
//				savedEmployee.getDepartmentCode()
//				);
		
		  EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);
				
		return savedEmployeeDto;
	}



	@Override
//	@CircuitBreaker(name="${spring.application.name}",fallbackMethod = "getDefaultDepartment")
	@Retry(name="${spring.application.name}",fallbackMethod = "getDefaultDepartment")
	public APIResponseDto getEmployeeById(long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();
		
		
		
//	    ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/department/" + employee.getDepartmentCode(),DepartmentDto.class);
//	    
//	    DepartmentDto departmentDto = responseEntity.getBody();
//		
		DepartmentDto departmentDto =webClient.get().uri("http://localhost:8082/api/department/" + employee.getDepartmentCode())
		.retrieve().bodyToMono(DepartmentDto.class).block();
    
		
//		DepartmentDto departmentDto = apiClient.getDeapartment(employee.getDepartmentCode());
		
//		EmployeeDto employeeDto = new EmployeeDto(
//				employee.getId(),
//				employee.getFirstName(),
//				employee.getLastName(),
//				employee.getEmail(),
//				employee.getDepartmentCode()
//				
//				);
		
		OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8085/api/organization/" + employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();
		
		 EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
		
		APIResponseDto apiResponseDto = new APIResponseDto();
		apiResponseDto.setEmployee(employeeDto);
		apiResponseDto.setDepartment(departmentDto);
		
		return apiResponseDto;
	}
	
	public APIResponseDto getDefaultDepartment(long employeeId, Exception exception) {
        Employee employee = employeeRepository.findById(employeeId).get();
		
		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setDepartmentName("R&D");
		departmentDto.setDepartmentDescription("Reasearch and Development");
		departmentDto.setDepartmentCode("RD001");
		
		    
				

				
//				EmployeeDto employeeDto = new EmployeeDto(
//						employee.getId(),
//						employee.getFirstName(),
//						employee.getLastName(),
//						employee.getEmail(),
//						employee.getDepartmentCode()
//						
//						);
		
		 EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
				
				APIResponseDto apiResponseDto = new APIResponseDto();
				apiResponseDto.setEmployee(employeeDto);
				apiResponseDto.setDepartment(departmentDto);
				
				return apiResponseDto;
		
	}

}
