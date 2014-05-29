package fr.skytech.application.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
    T create(T t);
    T find(PK id);
    List<T> findAll();
    T update(T t);
    void delete(T t);
}

