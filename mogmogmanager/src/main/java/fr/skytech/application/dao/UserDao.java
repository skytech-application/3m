package fr.skytech.application.dao;

import org.springframework.stereotype.Repository;

import fr.skytech.application.exception.TechnicalException;
import fr.skytech.application.model.User;

@Repository
public class UserDao extends GenericHibernateDao<User, Long> {

	public User findUserByUsername(String username)  throws TechnicalException {
		throw new TechnicalException("UserDao.findUserByUserName() not implemented");
	}

}
