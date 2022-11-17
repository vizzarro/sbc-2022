package it.aesys.courses.springboot.personregistry.dao;

import java.util.List;

public interface Dao<T> {

    T create(T t);
    T update(T t) ;
    void delete(String s);
    T get(String s);
    List<T> getAll();
}
