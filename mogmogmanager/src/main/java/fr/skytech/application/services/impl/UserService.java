package fr.skytech.application.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.skytech.application.adapter.IUserAdapter;
import fr.skytech.application.controller.dto.UserDto;
import fr.skytech.application.dao.IUserDao;
import fr.skytech.application.exception.FunctionalException;
import fr.skytech.application.exception.TechnicalException;
import fr.skytech.application.model.User;
import fr.skytech.application.services.IUserService;


@Service
public class UserService implements IUserService {

	@Autowired
	IUserDao dao;
	
	@Autowired
	IUserAdapter adapter;
	
	public UserDto findUserById(Long id) throws TechnicalException,FunctionalException {
		User user = dao.find(id);
		return adapter.modelToDTO(user);
	}
	
	public UserDto findUserByUsername(String username)  throws TechnicalException,FunctionalException  {
		User user = dao.findUserByUsername(username);
		return adapter.modelToDTO(user);
	}

	public List<UserDto> findAll() throws TechnicalException,FunctionalException{
		List<User> users = dao.findAll();
		List<UserDto> dtos = new ArrayList<UserDto>();
		for(User user : users){
			dtos.add(adapter.modelToDTO(user));
		}
		return dtos;
	}

	
	
}
