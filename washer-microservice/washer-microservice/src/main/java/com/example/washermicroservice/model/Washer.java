package com.example.washermicroservice.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="washers")
public class Washer {
	
	@Id
	private String id;
	
	@NotBlank(message="FirstName cannot be blank")
	private String firstName;
	
	private String lastName;
	
	private long mobileNo;
	
	@NotBlank(message="Email cannot be blank")
	@Email
	private String email;
	
	@NotBlank(message="Password cannot be Balnk")
	@Size(min=8, message="Password should contain at least 8 characters")
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Washer(String id, @NotBlank(message = "FirstName cannot be blank") String firstName, String lastName,
			long mobileNo, @NotBlank(message = "Email cannot be blank") @Email String email,
			@NotBlank(message = "Password cannot be Balnk") @Size(min = 8, message = "Password should contain at least 8 characters") String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
	}

	public Washer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
