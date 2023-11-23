package com.example.restapi.springbootrestapi.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.springbootrestapi.bean.Student;

@RestController
public class StudentController {
	
	@GetMapping("/student")
	public Student getStudent() {
		
		Student student = new Student();
			    student.setId(1);
			    student.setFirstName("Niraj");
			    student.setLastName("Kumar");
					
		return student;
				
	}
	
//	public  List<Student> getStudents(){
//		List<Student> students = new ArrayList();
//		students.add(new Student(2,"Akash","jain"));
//		students.add(new Student(3,"Niraj","Raj"));
//		students.add(new Student(4,"Aman","jain"));
//		
//		return students;
//		
//	}
	
	@GetMapping("/student/details")
	public List<Student> getStudentDetails(){
		
		List<Student> student = new ArrayList<Student>( Arrays.asList(
				new Student(1,"Niraj","Ray"),
				new Student(2,"Chaitra","R"),
				new Student(3,"Nayana","T")
				));
		return student;
	}
	
	@GetMapping("/student/{id}")
	public Student studentpathVariable(@PathVariable("id") int studentId) {
		return new Student(studentId,"Niraj","Kumar");
	}
	
	@GetMapping("/student/{id}/{first-name}/{last-name}")
	public Student studentpathVariables(@PathVariable("id") int studentId,
			                           @PathVariable("first-name") String firstName,@PathVariable("last-name") String lastName) {
		return new Student(studentId,firstName,lastName);
	}
	
	
	//spring boot rest api with query param
	//http://localhost:8080/student/query?id=1
	
	@GetMapping("student/query")
	public Student studentRequestParam(@RequestParam int id) {
		return new Student(id,"Niraj","Raj");
	}
	
	
	//http://localhost:8080/student/query?id=1&fisrtName=Akask&lastName=jain
	@GetMapping("student/queries")
	public Student studentRequestParams(@RequestParam int id,
			                            @RequestParam String firstName,@RequestParam String lastName) {
		return new Student(id,firstName,lastName);
	}
	
	
	//rest api to handle post request
	@PostMapping("/student/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
		
	//rest api handling put request
	@PutMapping("/student/{id}/update")
	public Student updateStudent(@RequestBody Student student, @PathVariable int id) {
		System.out.println(student.getFirstName());
		System.out.println(student.getLastName());
		return student;
	}
	
	//rest api t handle delte rquest
	
	@DeleteMapping("/student/{id}/delete")
	public String deleteStudent(@PathVariable int id) {
		System.out.println(id);
		return "student deleted successfully";
	}
	
	//resposneentityclass
	
	@GetMapping("/students")
	public ResponseEntity<Student> getStudents() {
		
		Student student = new Student();
			    student.setId(1);
			    student.setFirstName("Niraj");
			    student.setLastName("Kumar");
					
		return new ResponseEntity<>(student, HttpStatus.OK);
				
	}

}
