package com.javaguides.departmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title="Department-Service-Rest-Api-Documentation",
				description="Spring Boot Rest Api Documentation",
				version="v2.0",
				contact=@Contact(
						name="Niraj",
						email="nirajkumarlpu111@gmail.com"
						
						),
				license=@License(
						name="Apache2.0"
						)
				
				),
		externalDocs=@ExternalDocumentation(
				description="spring Boot Department Microservice Documentation")
		
		
			)
public class DepartmentServiceApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
