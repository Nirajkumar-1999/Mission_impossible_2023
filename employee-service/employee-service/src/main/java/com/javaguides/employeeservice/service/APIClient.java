//package com.javaguides.employeeservice.service;
//
//import org.springframework.cloud.openfeign.FeignClient;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import com.javaguides.employeeservice.dto.DepartmentDto;
//
//
//
//@FeignClient(url="http://localhost:8080", value="DEPARTMENT-SERVICE")
//public interface APIClient {
//	
//	@GetMapping("/api/department/{department-code}")
//	DepartmentDto getDeapartment(@PathVariable("department-code") String DepartmentCode);
//	
//	
//
//}
