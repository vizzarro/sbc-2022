package it.aesys.courses.springboot.dao.impl;

import com.mysql.cj.jdbc.Driver;
import it.aesys.courses.springboot.dao.Dao;
import it.aesys.courses.springboot.models.Document;
import it.aesys.courses.springboot.utils.connectionDb.ConnectionDb;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class DaoDocumentImpl implements Dao<Document> {

    private static  ConnectionDb connectionDB;
    private static final String INSERTQUERY="";
    private static final String SELECTALL="SELECT * FROM library.documenttest";

    @Autowired
    public DaoDocumentImpl(ConnectionDb connectionDB){
        this.connectionDB = connectionDB;
    }


    @Override
    public Document add(Document document) throws SQLException {
        Connection connection= connectionDB.register();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECTALL);

        return null;
    }

    @Override
    public Optional<Document> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Document> findAll() throws SQLException {
        Connection connection= connectionDB.register();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECTALL);
        while (resultSet.next()){
            System.out.println("cf: " + resultSet.getString("fiscalCode"));
        }
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
