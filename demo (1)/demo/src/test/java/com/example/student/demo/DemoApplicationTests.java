package com.example.student.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.student.demo.model.Student;
import com.example.student.demo.service.StudentService;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	
	  @Test
	    public void testStudentDetails() {
	        // Create a Student object
	        Student student = new Student();
	        student.setName("Niraj");
	        student.setAge(23);
	        student.setSalary(35000);
	 
	        // Verify student details
	        assertEquals("Niraj", student.getName());
	        assertEquals(23, student.getAge());
	        assertEquals(35000, student.getSalary(), 0.001); // Using delta for double comparison
	    }
	  
//	  
//	  @Test
//	    public void testDefaultStudentValues() {
//	        // Create a Student object with default values
//	        Student student = new Student();
//	 
//	        // Verify default values
//	        assertNull(student.getName());
//	        assertEquals(0, student.getAge());
//	        assertEquals(0.0, student.getSalary(), 0.001);
//	    }
//	    @Test   
//	    public void testGetAllStudents() {        
//	    Object studentservice;
//		List<Student> students = ((Object) studentservice).getAllStudents();       
//	    assertNotNull(students);  
//	    assertTrue(students.size() > 0);     }

}
