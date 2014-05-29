package fr.skytech.application.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.skytech.application.adapter.IUserAdapter;
import fr.skytech.application.controller.dto.UserDTO;
import fr.skytech.application.dao.IUserDao;
import fr.skytech.application.model.User;
import fr.skytech.application.services.IUserService;


@Service
public class UserService implements IUserService {

	@Autowired
	IUserDao dao;
	
	@Autowired
	IUserAdapter adapter;
	
	public UserDTO findUserById(Long id) {
		User user = dao.find(id);
		return adapter.modelToDTO(user);
	}
	
	public UserDTO findUserByUsername(String username) {
		User user = dao.findUserByUsername(username);
		return adapter.modelToDTO(user);
	}

	public List<UserDTO> findAll() {
		List<User> users = dao.findAll();
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		for(User user : users){
			dtos.add(adapter.modelToDTO(user));
		}
		return dtos;
	}

	
	
}
