package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.ui.UserResponseModel;
import com.example.dto.UserDto;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

	
	private final ModelMapper modelMapper;
	private final UserRepository userRepository;
	@Override
	public UserDto createUser(UserDto userDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity=modelMapper.map(userDto, UserEntity.class);
		StringBuffer buffer=new StringBuffer(userDto.getPassword());
		userEntity.setEncryptedPassword(buffer.reverse().toString());
		UserEntity tempUserEntity=userRepository.save(userEntity);
		
		return modelMapper.map(tempUserEntity, UserDto.class);
	}
	@Override
	public UserDto findByUserId(String id) {
		
		UserEntity tempUserEntity=userRepository.findByUserId(id);		
		if(tempUserEntity==null)
		{
			throw new UserNotFoundException("user not found");
		}
		return modelMapper.map(tempUserEntity, UserDto.class);
	}
	@Override
	public List<UserDto> getAllUsers() {
		 
		 	
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<UserEntity> list=userRepository.findAll();
		if(list.isEmpty())
		{
			throw new UserNotFoundException("users not Created");
		}
		List<UserDto> dtos=new ArrayList<UserDto>();
		for(UserEntity e: list)
		{
			dtos.add(modelMapper.map(e, UserDto.class));
		}
		return dtos;
	}
	@Override
	public UserDto findByEmail(String email) {
UserEntity tempUserEntity=userRepository.findByEmail(email);		
		
		return modelMapper.map(tempUserEntity, UserDto.class);
	}
	@Override
	public void deleteByUserId(String id) {
		// TODO Auto-generated method stub
		
		UserEntity user=userRepository.findByUserId(id);		
		if(user==null)
		{
			throw new UserNotFoundException("user not found");
		}
		userRepository.delete(user);
		
	}
	@Override
	public void deleteByEmail(String email) {
		// TODO Auto-generated method stub
		UserEntity tempUserEntity=userRepository.findByEmail(email);
		if(tempUserEntity==null)
		{
			throw new UserNotFoundException("user not found");
		}
		userRepository.delete(tempUserEntity);
		
	}
	@Override
	public UserDto updateUser(String id, UserDto userDto) {
		// TODO Auto-generated method stub
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity=modelMapper.map(userDto, UserEntity.class);
		UserEntity user=userRepository.findByUserId(id);
		if(user==null)
		{
			throw new UserNotFoundException("user not found");
		}
		user.setFirstName(userEntity.getFirstName());
		user.setLastName(userEntity.getLastName());
		user.setEmail(userEntity.getEmail());
		user.setEncryptedPassword(userEntity.getEncryptedPassword());
		UserEntity tempUserEntity=userRepository.save(user);
		return modelMapper.map(tempUserEntity, UserDto.class);
		
	}
	@Override
	public UserDto updateUserByEmail(String email, UserDto userDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity=modelMapper.map(userDto, UserEntity.class);
		UserEntity user=userRepository.findByEmail(email);
		if(user==null)
		{
			throw new UserNotFoundException("user not found");
		}
		user.setFirstName(userEntity.getFirstName());
		user.setLastName(userEntity.getLastName());
		user.setEmail(userEntity.getEmail());
		user.setEncryptedPassword(userEntity.getEncryptedPassword());
		UserEntity tempUserEntity=userRepository.save(user);
		return modelMapper.map(tempUserEntity, UserDto.class);
	}

}
