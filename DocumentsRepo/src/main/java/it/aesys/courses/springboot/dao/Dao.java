package it.aesys.courses.springboot.dao;

import it.aesys.courses.springboot.models.Document;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    T add(T t) throws SQLException;
    Optional<T> find(Integer id);
    List<T> findAll() throws SQLException;
    T edit(Integer id, T t);
    void delete(Integer id);






    }
