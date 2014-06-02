package fr.skytech.application.dao;

import fr.skytech.application.exception.TechnicalException;
import fr.skytech.application.model.User;

public interface IUserDao extends GenericDao<User, Long>{

	public User findUserByUsername(String username)  throws TechnicalException ;
	
}
