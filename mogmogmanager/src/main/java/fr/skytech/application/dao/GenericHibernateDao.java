package fr.skytech.application.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public abstract class GenericHibernateDao<T, PK extends Serializable>{

	protected Class<T> entityClass;
	
	@PersistenceContext(unitName = "JPAService")
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public GenericHibernateDao() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass
				.getActualTypeArguments()[0];
	}

	public T create(T t) {
		this.entityManager.persist(t);
		return t;
	}

	public T find(PK id) {
		return this.entityManager.find(entityClass, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return this.entityManager.createQuery("from " + entityClass.getName()).getResultList();
	}

	public T update(T t) {
		return this.entityManager.merge(t);
	}


	public void delete(T t) {
		t = this.entityManager.merge(t);
		this.entityManager.remove(t);
	}
}