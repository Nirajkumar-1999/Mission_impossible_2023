package com.javaguides.departmentservice.service;

import com.javaguides.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
	
	DepartmentDto savedDepartment(DepartmentDto departmentDto);
	
	DepartmentDto getDepartmentByCode(String code);
	

}
