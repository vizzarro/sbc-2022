package it.aesys.courses.springboot.personregistry.dao;

import it.aesys.courses.springboot.personregistry.dao.exception.DaoException;
import it.aesys.courses.springboot.personregistry.service.exceptions.ServiceException;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

    T create(T t) throws DaoException;
    T update(T t) throws DaoException;
    void delete(String s) throws DaoException;
    T get(String s) throws DaoException;
    List<T> getAll()throws DaoException ;
}
