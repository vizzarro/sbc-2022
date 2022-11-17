package it.aesys.courses.springboot.dao.impl;

import com.mysql.cj.jdbc.Driver;
import it.aesys.courses.springboot.dao.Dao;
import it.aesys.courses.springboot.models.Document;
import it.aesys.courses.springboot.models.TypeOfDoc;
import it.aesys.courses.springboot.models.TypeOfFile;
import it.aesys.courses.springboot.utils.connectionDb.ConnectionDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class DaoDocumentImpl implements Dao<Document> {

    private static final String INSERT="";
    private static final String SELECT_ALL="SELECT * FROM library.documents";
    private static final String FIND_BY_CF="SELECT * FROM library.documents  WHERE cf=?";

    private ConnectionDb connectionDB;

    @Autowired
    public DaoDocumentImpl(ConnectionDb connectionDB){
        this.connectionDB = connectionDB;
    }


    @Override
    public Document add(Document document){
        return null;
    }

    @Override
    public Optional<Document> find(Integer id) {
        return Optional.empty();
    }

    public List<Document> findByCf(String cf) throws SQLException {
        Connection connection= connectionDB.register();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(FIND_BY_CF);
        List<Document> documents = new ArrayList<>();
        while (resultSet.next()){
            Document document = new Document();
            if(resultSet.getString(1).equals(cf)){
                document.setIdDoc(resultSet.getInt("idDoc"));
                document.setNameFile(resultSet.getString("nameFile"));
                document.setTypeOfFile(TypeOfFile.valueOf(resultSet.getString("typeOfFile")));
                document.setTypeOfDoc(TypeOfDoc.valueOf(resultSet.getString("typeOfDoc")));
                document.setDataOfInput(resultSet.getDate("dataOfInput").toLocalDate());
                document.setFile(resultSet.getString("file"));
                document.setFiscalCode(resultSet.getString("fiscalCode"));
                documents.add(document);
            }
        }
        return documents;
    }

    @Override
    public List<Document> findAll() throws SQLException {
        Connection connection= connectionDB.register();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL);
        List<Document> documents = new ArrayList<>();
        Document document = new Document();
        while (resultSet.next()){
            document.setIdDoc(resultSet.getInt("idDoc"));
            document.setNameFile(resultSet.getString("nameFile"));
            document.setTypeOfFile(TypeOfFile.valueOf(resultSet.getString("typeOfFile")));
            document.setTypeOfDoc(TypeOfDoc.valueOf(resultSet.getString("typeOfDoc")));
            document.setDataOfInput(resultSet.getDate("dataOfInput").toLocalDate());
            document.setFile(resultSet.getString("file"));
            document.setFiscalCode(resultSet.getString("fiscalCode"));
            documents.add(document);
        }
        return documents;
    }

    @Override
    public Document edit(Integer id, Document document) {
        return null;
    }

    @Override
    public void delete(Integer id) throws SQLException {
        Connection connection= connectionDB.register();
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM library.documents WHERE idDoc = " + id);
    }
}
