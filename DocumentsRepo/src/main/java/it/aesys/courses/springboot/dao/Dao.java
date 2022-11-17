package it.aesys.courses.springboot.dao;

import it.aesys.courses.springboot.models.Document;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    T add(T t);
    Optional<T> find(Integer id);
    List<T> findAll();
    T edit(Integer id, T t);
    void delete(Integer id);






    }
