package fr.skytech.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.skytech.application.adapter.UserAdapter;
import fr.skytech.application.controller.dto.UserDto;
import fr.skytech.application.dao.UserDao;
import fr.skytech.application.exception.FunctionalException;
import fr.skytech.application.exception.TechnicalException;
import fr.skytech.application.model.User;


@Service
public class UserService {

	@Autowired
	UserDao dao;
	
	@Autowired
	UserAdapter adapter;
	
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
