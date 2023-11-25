package com.javaguides.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaguides.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
