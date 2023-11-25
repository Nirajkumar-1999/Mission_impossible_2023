package com.javaguides.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaguides.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	Department findByDepartmentCode(String departmentCode);

}
