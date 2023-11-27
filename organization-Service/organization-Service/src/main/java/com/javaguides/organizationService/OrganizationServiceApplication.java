package com.javaguides.organizationService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title="Organization-Service-Rest-Api-Documentation",
				description="Spring Boot Organization Rest Api Documentation",
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
				description="spring Boot Organization Microservice Documentation")
		)
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
