package it.aesys.courses.springboot.personregistry.dao;

public interface Dao<T> {

    <T> create(<T>);
    <T> update(<T>);
    void delete(String);
    <T> get(String);
    <List<T>> getAll();
}
