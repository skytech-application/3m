package fr.skytech.application.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import fr.skytech.application.dao.GenericHibernateDAO;
import fr.skytech.application.dao.IUserDao;
import fr.skytech.application.exception.TechnicalException;
import fr.skytech.application.model.User;

@Repository
public class UserDAO extends GenericHibernateDAO<User, Long> implements
		IUserDao {

	@Value("${mock}")
	protected boolean mock;

	public User find(Long id) {
		if (mock) {
			User user = new User();
			user.setId(id);
			user.setUsername("tolotolo " + id);
			return user;
		} else {
			return super.find(id);
		}

	}

	public User findUserByUsername(String username) {
		if (mock) {
			User user = new User();
			user.setId(1L);
			user.setUsername(username);
			return user;
		} else {
			throw new TechnicalException("findUserByUserName not implemented");
		}

	}

	public List<User> findAll() {
		if (mock) {
			List<User> users = new ArrayList<User>();
			users.add(find(1L));
			users.add(find(2L));
			users.add(find(3L));
			users.add(find(4L));
			return users;
		} else {
			return super.findAll();
		}

	}

}
