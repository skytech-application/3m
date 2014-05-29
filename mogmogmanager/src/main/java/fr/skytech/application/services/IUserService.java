package fr.skytech.application.services;

import java.util.List;

import fr.skytech.application.controller.dto.UserDto;

public interface IUserService {

	public UserDto findUserById(Long id);
	public UserDto findUserByUsername(String username);
	public List<UserDto> findAll();
	
}
