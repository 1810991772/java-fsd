package com.example.demo.service;



import java.util.List;

import com.example.demo.ui.UserResponseModel;
import com.example.dto.UserDto;

public interface UserService {
	
	public UserDto createUser(UserDto userDto);

	public UserDto findByUserId(String id);

	public List<UserDto> getAllUsers();

	public UserDto findByEmail(String email);

	public void deleteByUserId(String id);

	public void deleteByEmail(String email);

	public UserDto updateUser(String id,UserDto userDto);

	public UserDto updateUserByEmail(String email, UserDto userDto);

}
