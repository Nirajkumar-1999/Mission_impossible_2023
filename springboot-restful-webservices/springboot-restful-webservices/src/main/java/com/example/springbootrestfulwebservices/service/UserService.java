package com.example.springbootrestfulwebservices.service;

import java.util.List;

import com.example.springbootrestfulwebservices.dto.UserDto;
import com.example.springbootrestfulwebservices.entity.User;

public interface UserService {
//	User createUser(User user);
	
	UserDto createUser(UserDto user);
	
//	User getUserById(long userId);
	
	UserDto getUserById(long userId);
	
//	List<User> getAllUsers();
	
	List<UserDto> getAllUsers();
	
//	User updateUser(User user);
	
	UserDto updateUser(UserDto user);
	
	void deleteUser(long userId);

}
