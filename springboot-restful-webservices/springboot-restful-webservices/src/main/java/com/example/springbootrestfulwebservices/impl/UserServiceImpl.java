package com.example.springbootrestfulwebservices.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.springbootrestfulwebservices.dto.UserDto;
import com.example.springbootrestfulwebservices.entity.User;
import com.example.springbootrestfulwebservices.exception.EmailAlreadyExist;
import com.example.springbootrestfulwebservices.exception.ResourceNotFoundException;
import com.example.springbootrestfulwebservices.mapper.AutoUserMapper;
import com.example.springbootrestfulwebservices.mapper.UserMapper;
import com.example.springbootrestfulwebservices.repository.UserRepository;
import com.example.springbootrestfulwebservices.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	private ModelMapper modelMapper;
	
	private UserRepository userRepository;

//	@Override
//	public User createUser(User user) {
//		// TODO Auto-generated method stub
//		
//		return userRepository.save(user);
//	}
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		//convert UserDto into jpa entity
//		User user = new User(
//				userDto.getId(),
//				userDto.getFirstName(),
//				userDto.getLastName(),
//				userDto.getEmail()
//				);
		
//		User user = UserMapper.mapToUser(userDto);
		
//		User user = modelMapper.map(userDto, User.class);
		
		Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
		
		if(optionalUser.isPresent()) {
			throw new EmailAlreadyExist("Email already exist");
		}
		
		User user = AutoUserMapper.Mapper.mapToUser(userDto);
		User savedUser = userRepository.save(user);
		
		
		// convert user jpa entity to userdto
//		UserDto savedUserDto = new UserDto(
//				savedUser.getId(),
//				savedUser.getFirstName(),
//				savedUser.getLastName(),
//				savedUser.getEmail()
//				);
		
//		UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
		
//		UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);
//		
		UserDto savedUserDto = AutoUserMapper.Mapper.mapToUserDto(savedUser);
		return savedUserDto;
	}

//	@Override
//	public User getUserById(long userId) {
//		// TODO Auto-generated method stub
//		 Optional<User> optionalUser = userRepository.findById(userId);
//		 return optionalUser.get();
//	}
	
	@Override
	public UserDto getUserById(long userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User", "id", userId) );
//		 User user = optionalUser.get();
//		 return UserMapper.mapToUserDto(user);
//		 return modelMapper.map(user, UserDto.class);
		 return AutoUserMapper.Mapper.mapToUserDto(user);
	}

//	@Override
//	public List<User> getAllUsers() {
//		// TODO Auto-generated method stub
//		return userRepository.findAll();
//	}
	
	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findAll();
//		return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
//		return users.stream().map((user) -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return users.stream().map((user) -> AutoUserMapper.Mapper.mapToUserDto(user)).collect(Collectors.toList());
	}

//	@Override
//	public User updateUser(User user) {
//		// TODO Auto-generated method stub
//		User existingUser = userRepository.findById(user.getId()).get();
//		existingUser.setFirstName(user.getFirstName());
//		existingUser.setLastName(user.getLastName());
//		existingUser.setEmail(user.getEmail());
//		User updatedUser = userRepository.save(existingUser);
//		return updatedUser;
//	}
	
	@Override
	public UserDto updateUser(UserDto user) {
		// TODO Auto-generated method stub
		User existingUser = userRepository.findById(user.getId()).orElseThrow(
				() -> new ResourceNotFoundException("User", "id", user.getId()));
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		User updatedUser = userRepository.save(existingUser);
//		return UserMapper.mapToUserDto(updatedUser);
//		return modelMapper.map(updatedUser, UserDto.class);
		return AutoUserMapper.Mapper.mapToUserDto(updatedUser);
	}

	@Override
	public void deleteUser(long userId) {
		// TODO Auto-generated method stub
		User existingUser = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User", "id", userId));
		userRepository.deleteById(userId);
		
	}
	

}
