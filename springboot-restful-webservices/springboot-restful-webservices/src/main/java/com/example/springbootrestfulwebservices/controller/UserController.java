package com.example.springbootrestfulwebservices.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.example.springbootrestfulwebservices.dto.UserDto;
import com.example.springbootrestfulwebservices.entity.User;
import com.example.springbootrestfulwebservices.exception.ErrorDetails;
import com.example.springbootrestfulwebservices.exception.ResourceNotFoundException;
import com.example.springbootrestfulwebservices.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@ResponseBody
@AllArgsConstructor
@RequestMapping("/api/users")
@Tag(
		name="Crud Operations For User Resource",
		description="create User,Update User,Get User, Delete User")
public class UserController {
	
	private UserService userService;
	
	//create user rest api
	
//	@PostMapping
//	public ResponseEntity<User> createUser(@RequestBody User user){
//		User savedUser = userService.createUser(user);
//		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
//	}
	
	//dto 
	
	@PostMapping
	@Operation(
			summary="Create User Rest API",
			description="Create user rest api is used to save user in database"
			)
	@ApiResponse(
			responseCode="201",
			description="HTTP status 201 created"
			)
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
		UserDto savedUser = userService.createUser(user);
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
	}
	
	
	//get userByid
//	@GetMapping("{id}")
//	public ResponseEntity<User> getUserById(@PathVariable("id") long userId){
//		User user = userService.getUserById(userId);
//		return new ResponseEntity<>(user,HttpStatus.OK);
//	}
	
	//get userByid using DTO
	@GetMapping("{id}")
	@Operation(
			summary="Get UserById Rest API",
			description="Get single user detail by Id"
			)
	@ApiResponse(
			responseCode="200",
			description="HTTP status 200 success"
			)
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") long userId){
		UserDto user = userService.getUserById(userId);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	
	//get allusers
//	@GetMapping()
//	public ResponseEntity<List<User>> getAllUser(){
//	List<User> user = userService.getAllUsers();
//	return new ResponseEntity<>(user,HttpStatus.OK);
//		
//	}
	
	//get alluser by userDto
	@GetMapping()
	@Operation(
			summary="Get All User Rest API",
			description="Get All the Users From Database"
			)
	@ApiResponse(
			responseCode="200",
			description="HTTP status 200 created"
			)
	public ResponseEntity<List<UserDto>> getAllUser(){
	List<UserDto> user = userService.getAllUsers();
	return new ResponseEntity<>(user,HttpStatus.OK);
		
	}
	
	//update user
//	@PutMapping("{id}")
//	public ResponseEntity<User> updateUser(@PathVariable("id") long userId, @RequestBody User user){
//		user.setId(userId);
//		User updatedUser = userService.updateUser(user);
//		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
//	}
	
	//update user by userDto
		@PutMapping("{id}")
		@Operation(
				summary="Update User Rest API",
				description="Update user rest api is used to update a particular user in database"
				)
		@ApiResponse(
				responseCode="200",
				description="HTTP status 200 created"
				)
		public ResponseEntity<UserDto> updateUser(@PathVariable("id") long userId, @RequestBody @Valid UserDto user){
			user.setId(userId);
			UserDto updatedUser = userService.updateUser(user);
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		}
	
	//delete user
	
	@DeleteMapping("{id}")
	@Operation(
			summary="Delete User Rest API",
			description="Delete user rest api is used to delete a particular user in database"
			)
	@ApiResponse(
			responseCode="200",
			description="HTTP status 200 created"
			)
	public ResponseEntity<String> deleteUser(@PathVariable("id") long userId){
		userService.deleteUser(userId);
		return new ResponseEntity<>("User successfuly delted",HttpStatus.OK);
	}
	
//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest ){
//		
//		ErrorDetails erroDetails = new ErrorDetails(
//				LocalDateTime.now(),
//				exception.getMessage(),
//				webRequest.getDescription(false),
//				"User Not Found"
//				);
//		return new ResponseEntity<>(erroDetails,HttpStatus.NOT_FOUND);
//	}

}
