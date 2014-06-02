package fr.skytech.application.dao;

import java.io.Serializable;
import java.util.List;

import fr.skytech.application.exception.TechnicalException;

public interface GenericDao<T, PK extends Serializable> {
    T create(T t)  throws TechnicalException ;
    T find(PK id) throws TechnicalException ;
    List<T> findAll() throws TechnicalException ;
    T update(T t) throws TechnicalException ;
    void delete(T t) throws TechnicalException ;
}

