package fr.skytech.application.dao;

import java.util.List;

import fr.skytech.application.model.User;

public interface IUserDAO {

	public User findUserById(Integer id);
	public User findUserByUsername(String username);
	public List<User> findAll();
	
}
