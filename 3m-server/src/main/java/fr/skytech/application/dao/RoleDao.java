package fr.skytech.application.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.skytech.application.exception.TechnicalException;
import fr.skytech.application.model.Role;

@Repository
public class RoleDao extends GenericHibernateDao<Role, Long> {

	public Role findRoleByName(final String name) throws TechnicalException {
		try {
			final Query query = this.entityManager
					.createQuery("from Role r where r.name = :name");
			query.setParameter("name", name);
			return (Role) query.getSingleResult();
		} catch (final Exception e) {
			throw new TechnicalException("Impossible to find role by name : "
					+ name);
		}

	}
}
