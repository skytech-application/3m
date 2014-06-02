package fr.skytech.application.dao.impl;

import org.springframework.stereotype.Repository;

import fr.skytech.application.dao.GenericHibernateDao;
import fr.skytech.application.dao.IUserDao;
import fr.skytech.application.exception.TechnicalException;
import fr.skytech.application.model.User;

@Repository
public class UserDao extends GenericHibernateDao<User, Long> implements
		IUserDao {

	public User findUserByUsername(String username) {
		throw new TechnicalException("findUserByUserName not implemented");
	}

}
