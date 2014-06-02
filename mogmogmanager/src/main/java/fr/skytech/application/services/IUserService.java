package fr.skytech.application.services;

import java.util.List;

import fr.skytech.application.controller.dto.UserDto;
import fr.skytech.application.exception.FunctionalException;
import fr.skytech.application.exception.TechnicalException;

public interface IUserService {

	public UserDto findUserById(Long id) throws TechnicalException,FunctionalException;
	public UserDto findUserByUsername(String username) throws TechnicalException,FunctionalException;
	public List<UserDto> findAll() throws TechnicalException,FunctionalException;
	
}
