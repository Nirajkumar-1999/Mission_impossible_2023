package com.example.student.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.example.student.demo.model.Student;
import com.example.student.demo.repository.StudentRepo;

import io.swagger.v3.oas.annotations.parameters.RequestBody;






@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentrepo;
	
public Student addStudent(Student student) {
		
		return studentrepo.save(student);
	}

public List<Student> findAllStudent(){
	
	return studentrepo.findAll();
}

public void updatedetails(String name, Student student) {
	studentrepo.save(student);
}

//public void deleteDetails(String name) {
//	studentrepo.deleteAll(name);
//}


}
