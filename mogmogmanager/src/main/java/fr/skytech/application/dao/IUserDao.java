package fr.skytech.application.dao;

import fr.skytech.application.model.User;

public interface IUserDao{

	public User findUserByUsername(String username);
}