package com.javaguides.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title="Employee-Service-Rest-Api-Documentation",
				description="Spring Boot Employee Service Rest Api Documentation",
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
				description="spring Boot Employee Microservice Documentation")
		
		
			)
public class EmployeeServiceApplication {
	
//	@Bean
//	public RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
	
	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
