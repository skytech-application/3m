package fr.skytech.application.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.skytech.application.exception.TechnicalException;
import fr.skytech.application.model.User;

@Repository
public class UserDao extends GenericHibernateDao<User, Long> {

	public boolean existUsername(final String username) {
		try {
			final Query query = this.entityManager
					.createQuery("from User u where u.username = :username");
			query.setParameter("username", username);
			if (query.getResultList().size() == 0) {
				return false;
			} else {
				return true;
			}
		} catch (final Exception e) {
			return false;
		}

	}

	public User findUserByUsername(final String username)
			throws TechnicalException {
		try {
			final Query query = this.entityManager
					.createQuery("from User u where u.username = :username");
			query.setParameter("username", username);
			return (User) query.getSingleResult();
		} catch (final Exception e) {
			throw new TechnicalException(
					"Impossible to find user by username : " + username);
		}

	}

}
