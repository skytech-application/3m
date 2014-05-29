package fr.skytech.application.services;

import java.util.List;

import fr.skytech.application.controller.dto.UserDTO;

public interface IUserService {

	public UserDTO findUserById(Long id);
	public UserDTO findUserByUsername(String username);
	public List<UserDTO> findAll();
	
}
