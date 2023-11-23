package com.example.springbootrestfulwebservices.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrestfulwebservices.entity.User;
import com.example.springbootrestfulwebservices.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@ResponseBody
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
	
	private UserService userService;
	
	//create user rest api
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser = userService.createUser(user);
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
	}
	
	//get userByid
	
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long userId){
		User user = userService.getUserById(userId);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	//get allusers
	
	@GetMapping()
	public ResponseEntity<List<User>> getAllUser(){
	List<User> user = userService.getAllUsers();
	return new ResponseEntity<>(user,HttpStatus.OK);
		
	}
	
	//update user
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long userId, @RequestBody User user){
		user.setId(userId);
		User updatedUser = userService.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	//delete user
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long userId){
		userService.deleteUser(userId);
		return new ResponseEntity<>("User successfuly delted",HttpStatus.OK);
	}

}
