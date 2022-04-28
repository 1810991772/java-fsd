package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.UserService;
import com.example.demo.ui.UserRequestModel;
import com.example.demo.ui.UserResponseModel;
import com.example.dto.UserDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {

	private final ModelMapper modelMapper;
	private final Environment environment;
	private final UserService userService;

	@RequestMapping
	public ResponseEntity<?> getStatus() {
		return ResponseEntity.ok("user-ws is up and running on port: " + environment.getProperty("local.server.port"));
	}

	@PostMapping("/users")
	public ResponseEntity<UserResponseModel> createUser(@RequestBody UserRequestModel userRequestModel) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userRequestModel, UserDto.class);
		userDto.setUserId(UUID.randomUUID().toString());
		UserDto tempUserDto = userService.createUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(tempUserDto, UserResponseModel.class));
	}

	@GetMapping("/users")
	public ResponseEntity<List<UserResponseModel>> getAllUsers() {
		List<UserDto> dtos = userService.getAllUsers();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<UserResponseModel> users = new ArrayList<UserResponseModel>();
		for (UserDto d : dtos) {
			users.add(modelMapper.map(d, UserResponseModel.class));
		}
		return ResponseEntity.ok(users);
	}


	@GetMapping("/{userId}")
	public ResponseEntity<UserResponseModel> getUserById(@PathVariable(name = "userId") String id) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto tempUserDto = userService.findByUserId(id);
		if (tempUserDto == null) {
			throw new UserNotFoundException("user  not found Please create first");
		} else
			return ResponseEntity.ok().body(modelMapper.map(tempUserDto, UserResponseModel.class));
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<UserResponseModel> getUserByEmail(@PathVariable(name = "email") String email) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto tempUserDto = userService.findByEmail(email);
		if (tempUserDto == null) {
			throw new UserNotFoundException("user  not found Please create first");
		} else
			return ResponseEntity.ok().body(modelMapper.map(tempUserDto, UserResponseModel.class));
	}

	@DeleteMapping("/user/{userId}")
	public ResponseEntity<?> deleteById(@PathVariable(name = "userId") String id) {
		userService.deleteByUserId(id);
		return ResponseEntity.status(HttpStatus.OK).body("deletion sucess.!!!");
	}
	@DeleteMapping("/user/email/{email}")
	public ResponseEntity<?> deleteByUserEmail(@PathVariable(name = "email") String email) {
		userService.deleteByEmail(email);
		return ResponseEntity.status(HttpStatus.OK).body("deletion sucess.!!!");
	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<UserResponseModel> updateUser(@PathVariable(name = "userId") String id,@RequestBody UserRequestModel userRequestModel)
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userRequestModel, UserDto.class);
		UserDto tempUserDto = userService.updateUser(id,userDto);
		return ResponseEntity.ok().body(modelMapper.map(tempUserDto, UserResponseModel.class));
	
	}
	@PutMapping("/update/emailid/{email}")
	public ResponseEntity<UserResponseModel> updateUserByEmail(@PathVariable(name = "email") String email,@RequestBody UserRequestModel userRequestModel)
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = modelMapper.map(userRequestModel, UserDto.class);
		UserDto tempUserDto = userService.updateUserByEmail(email,userDto);
		return ResponseEntity.ok().body(modelMapper.map(tempUserDto, UserResponseModel.class));
	
	}
}
