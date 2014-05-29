package fr.skytech.application.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.skytech.application.dao.IUserDAO;
import fr.skytech.application.model.User;

@Repository
public class UserDAO implements IUserDAO{

	public User findUserById(Integer id) {
		User user = new User();
		user.setId(id);
		user.setUsername("tolotolo " + id);
		return user;
	}
	
	public User findUserByUsername(String username) {
		User user = new User();
		user.setId(1);
		user.setUsername(username);
		return user;
	}

	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		
		users.add(findUserById(1));
		users.add(findUserById(2));
		users.add(findUserById(3));
		users.add(findUserById(4));
		
		return users;
	}

}
