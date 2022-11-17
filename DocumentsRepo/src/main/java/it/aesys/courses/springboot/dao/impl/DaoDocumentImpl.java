package it.aesys.courses.springboot.dao.impl;

import it.aesys.courses.springboot.dao.Dao;
import it.aesys.courses.springboot.models.Document;
import it.aesys.courses.springboot.utils.connectionDb.ConnectionDb;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DaoDocumentImpl implements Dao<Document> {

    ConnectionDb connectionDB;

    @Autowired
    public DaoDocumentImpl(ConnectionDb connectionDB){
        this.connectionDB = connectionDB;
    }


    @Override
    public Document add(Document document) {
        connectionDB.register();
        return null;
    }

    @Override
    public Optional<Document> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Document> findAll() {
        return null;
    }

    @Override
    public Document edit(Integer id, Document document) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
