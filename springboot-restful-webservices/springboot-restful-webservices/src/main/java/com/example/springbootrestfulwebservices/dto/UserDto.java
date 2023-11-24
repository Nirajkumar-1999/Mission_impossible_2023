package com.example.springbootrestfulwebservices.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;

@Schema(
		description="UserDto Model Information")
@AllArgsConstructor
public class UserDto {
	
	private long id;
	@NotEmpty
	@Schema(
			description="User FirstName"
			)
	private String firstName;
	@NotEmpty
	@Schema(
			description="User LastName"
			)
	private String lastName;
	@NotEmpty
	@Email
	@Schema(
			description="User EmailId"
			)
	private String email;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
	

}
