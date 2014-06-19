package fr.skytech.application.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import fr.skytech.application.exception.TechnicalException;

@Component
public abstract class GenericHibernateDao<T, PK extends Serializable> {

	protected Class<T> entityClass;

	@PersistenceContext(unitName = "JPAService")
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public GenericHibernateDao() {
		final ParameterizedType genericSuperclass = (ParameterizedType) this
				.getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass
				.getActualTypeArguments()[0];
	}

	public T create(final T t) throws TechnicalException {
		try {
			this.entityManager.persist(t);
		} catch (final Exception e) {
			throw new TechnicalException("Impossible to persist "
					+ t.getClass().getSimpleName());
		}
		return t;
	}

	public boolean delete(T t) throws TechnicalException {
		try {
			t = this.entityManager.merge(t);
			this.entityManager.remove(t);
			return true;
		} catch (final Exception e) {
			throw new TechnicalException("error.delete");
		}
	}

	public T find(final PK id) throws TechnicalException {
		final T entity = this.entityManager.find(this.entityClass, id);
		if (entity == null) {
			throw new TechnicalException(this.entityClass.getSimpleName()
					+ " not found with id :" + id);
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() throws TechnicalException {
		try {
			return this.entityManager.createQuery(
					"from " + this.entityClass.getName()).getResultList();
		} catch (final Exception e) {
			throw new TechnicalException("Impossible to get all "
					+ this.entityClass.getSimpleName());
		}
	}

	public void flush() {
		this.entityManager.flush();
	}

	public T update(final T t) throws TechnicalException {
		try {
			return this.entityManager.merge(t);
		} catch (final Exception e) {
			throw new TechnicalException("Impossible to update "
					+ this.entityClass.getSimpleName());
		}
	}
}