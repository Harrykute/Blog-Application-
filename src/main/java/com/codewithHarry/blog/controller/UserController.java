package com.codewithHarry.blog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codewithHarry.blog.payloads.ApiResponse;
import com.codewithHarry.blog.payloads.UserDto;
import com.codewithHarry.blog.services.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping(value="/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	//POST - create user 
	@PostMapping(value="/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){

		UserDto createUserDto = this.userService.createuser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	

	//PUT - update user 
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto , @PathVariable("userId") Integer uid){
		
		UserDto updateUserDto = this.userService.updateUser(userDto, uid);
		
		return ResponseEntity.ok(updateUserDto);
		
	}
	
	
	//DELETE - delete user 
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid){
		
	    this.userService.deleteuser(uid);	
	    return new ResponseEntity(new ApiResponse("user Deleted succesfully",true),HttpStatus.OK);
	}
	

	//GET  - get By user ID 
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getOneUser(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
	
	//GET - get all Users 
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
}
