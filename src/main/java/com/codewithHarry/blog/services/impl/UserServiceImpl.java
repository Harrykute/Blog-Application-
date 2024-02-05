package com.codewithHarry.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codewithHarry.blog.entities.User;
import com.codewithHarry.blog.exception.ResourceNotFoundException;
import com.codewithHarry.blog.payloads.UserDto;
import com.codewithHarry.blog.repositories.UserRepo;
import com.codewithHarry.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired  //injecting object of userRepo 
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public UserDto createuser(UserDto userDto) {
		
		User user =this.dtoTouser(userDto);
		
		User savedUser = this.userRepo.save(user);
		
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
	
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," id ",userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id", userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users = this.userRepo.findAll();
		
		List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteuser(Integer userId) {
		
		User user =  this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User"," id ", userId));    
		this.userRepo.delete(user);
	}
	
	/*The methods dtoToUser and userToDto are created to facilitate 
	  the conversion between the entities (in this case, the User entity) and 
	  the data transfer objects (DTOs, in this case, UserDto).
	 
	 *These methods help in mapping the data between the entity and DTO, 
	  which is a common practice in software development, 
	  especially when dealing with data persistence and communication between 
	  different layers of an application. 
	 
	 * */

	//crating method for Data transfer Object 
	//we use this method Through model mapping libraries 
	private User dtoTouser(UserDto userDto) {
		
		
		//using model Mapper 
		User user = this.modelMapper.map(userDto,User.class);
		
		
		
//		User user = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		user.setPassword(userDto.getPassword());
		return user;
	}
	
	private UserDto userToDto(User user) {
		
		//using model Mapper
		UserDto userDto = this.modelMapper.map(user,UserDto.class);   

		
		//By Normal method
		//		UserDto userDto = new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setAbout(user.getAbout());
//		userDto.setPassword(user.getPassword());
		return userDto;
	}
	
	
	
	

}
