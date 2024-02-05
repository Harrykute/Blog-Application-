package com.codewithHarry.blog.services;


import java.util.List;

import com.codewithHarry.blog.payloads.UserDto;

public interface UserService {

	UserDto createuser(UserDto userDto);
	UserDto updateUser(UserDto userDto,Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteuser(Integer userId);
}
