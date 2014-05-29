package fr.skytech.application.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class GenericHibernateDAO<T, PK extends Serializable>
		implements GenericDao<T, PK> {

	protected Class<T> entityClass;

	@PersistenceContext(unitName = "JPAService")
	private EntityManager entityManager;

	public GenericHibernateDAO() {
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