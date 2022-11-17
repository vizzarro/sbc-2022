package it.aesys.courses.springboot.personregistry.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

    T create(T t) throws SQLException;
    T update(T t) throws SQLException;
    void delete(String s) throws SQLException;
    T get(String s) throws SQLException;
    List<T> getAll()throws SQLException ;
}
