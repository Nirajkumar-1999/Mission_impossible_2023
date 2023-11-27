package com.javaguides.departmentservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.javaguides.departmentservice.dto.DepartmentDto;
import com.javaguides.departmentservice.service.DepartmentService;

@SpringBootTest
class DepartmentServiceApplicationTests {
	
	@Autowired
	private DepartmentService departmentService;

	@Test
	void contextLoads() {
		
		
		
		DepartmentDto inputDto = new DepartmentDto(1,"IT","Information Technology","It001");
		
		DepartmentDto saveDto = departmentService.savedDepartment(inputDto);
		
		assertNotNull(saveDto.getId());
		assertEquals(inputDto.getDepartmentName(), saveDto.getDepartmentName());
		assertEquals(inputDto.getDepartmentDescription(), saveDto.getDepartmentDescription());
		assertEquals(inputDto.getDepartmentCode(), saveDto.getDepartmentCode());
	}

}
