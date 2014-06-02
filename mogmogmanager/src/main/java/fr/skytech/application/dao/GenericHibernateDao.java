package fr.skytech.application.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import fr.skytech.application.exception.TechnicalException;

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

	public T create(T t) throws TechnicalException{
		try{
			this.entityManager.persist(t);
		}catch(Exception e){
			throw new TechnicalException("Impossible to persist " + t.getClass().getSimpleName());
		}
		return t;
	}

	public T find(PK id) throws TechnicalException{
		T entity = this.entityManager.find(entityClass, id);
		if(entity == null) throw new TechnicalException(entityClass.getSimpleName() + " not found with id :" + id);
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() throws TechnicalException {
		try{
			return this.entityManager.createQuery("from " + entityClass.getName()).getResultList();
		}catch(Exception e){
			throw new TechnicalException("Impossible to get all " + entityClass.getSimpleName());
		}
	}

	public T update(T t) throws TechnicalException {
		try{
			return this.entityManager.merge(t);
		}catch(Exception e){
			throw new TechnicalException("Impossible to update " + entityClass.getSimpleName());
		}
	}


	public void delete(T t) throws TechnicalException {
		try{
			t = this.entityManager.merge(t);
			this.entityManager.remove(t);
		}catch(Exception e){
			throw new TechnicalException("Impossible to delete " + entityClass.getSimpleName());
		}
	}
}