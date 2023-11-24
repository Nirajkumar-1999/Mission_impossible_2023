package com.example.springbootrestfulwebservices;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(
			title="spring-boot-rest-spi-documentation",
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
			description="spring Boot User Management Documentation")
	
	
		)
public class SpringbootRestfulWebservicesApplication {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
	}

}
