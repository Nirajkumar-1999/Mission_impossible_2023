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

@RestController
@RequestMapping("/api/department")
public class DepartmentContoller {
	
	private DepartmentService departmentService;

	public DepartmentContoller(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}
	
	//Build save Department Rest Api
	
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
		
		DepartmentDto savedDepartment =departmentService.savedDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartment,HttpStatus.CREATED);
	}
	
	//Build Get Department Rest Api
	@GetMapping("{department-code}")
	public ResponseEntity<DepartmentDto> getDeapartment(@PathVariable("department-code") String DepartmentCode){
		DepartmentDto departmentDto = departmentService.getDepartmentByCode(DepartmentCode);
		return new ResponseEntity<>(departmentDto,HttpStatus.OK);
	}
	
	
	
	

}
