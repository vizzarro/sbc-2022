package it.aesys.courses.springboot.dao.impl;

import it.aesys.courses.springboot.dao.Dao;
import it.aesys.courses.springboot.models.Document;
import it.aesys.courses.springboot.models.TypeOfDoc;
import it.aesys.courses.springboot.models.TypeOfFile;
import it.aesys.courses.springboot.utils.connectionDb.ConnectionDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DaoDocumentImpl implements Dao<Document> {

    private static final String INSERT = "INSERT INTO library.documents (`nameFile`, `dataOfInput`, `typeOfFile`, `typeOfDoc`, `file`, `fiscalCode`) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM library.documents";
    private static final String SELECT_BY_CF = "SELECT * FROM library.documents  WHERE fiscalCode = ? ";
    private static final String SELECT_BY_ID = "SELECT * FROM library.documents WHERE idDoc = ? ";
    private static final String UPDATE = "UPDATE library.documents SET nameFile=?, dataOfInput=?, typeOfFile=?, typeOfDoc=?, file=?, fiscalCode=? WHERE idDoc = ?";
    private static final String DELETE = "DELETE FROM library.documents WHERE idDoc = ? ";
    private ConnectionDb connectionDB;

    @Autowired
    public DaoDocumentImpl(ConnectionDb connectionDB) {
        this.connectionDB = connectionDB;
    }

    @Override
    public Document add(Document document) {
        String nameFile = document.getNameFile();
        LocalDate dataOfInput = document.getDataOfInput();
        TypeOfFile typeOfFile = document.getTypeOfFile();
        TypeOfDoc typeOfDoc = document.getTypeOfDoc();
        String file = document.getFile();
        String fiscalCode = document.getFiscalCode();
        Connection connection = connectionDB.register();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, nameFile);
            statement.setDate(2, Date.valueOf(dataOfInput));
            statement.setString(3, typeOfFile.name());
            statement.setString(4, typeOfDoc.name());
            statement.setString(5, file);
            statement.setString(6, fiscalCode);
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    document.setIdDoc(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Creating document failed, no ID obtained.");
                }
            }
            return document;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Document edit(Integer id, Document document) {
        String nameFile = document.getNameFile();
        LocalDate dataOfInput = document.getDataOfInput();
        TypeOfFile typeOfFile = document.getTypeOfFile();
        TypeOfDoc typeOfDoc = document.getTypeOfDoc();
        String file = document.getFile();
        String fiscalCode = document.getFiscalCode();
        Connection connection = connectionDB.register();
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE);
            statement.setString(1, nameFile);
            statement.setDate(2, Date.valueOf(dataOfInput));
            statement.setString(3, typeOfFile.name());
            statement.setString(4, typeOfDoc.name());
            statement.setString(5, file);
            statement.setString(6, fiscalCode);
            statement.setInt(7, id);
            statement.executeUpdate();
            return find(id).get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Document> findByCf(String cf) throws SQLException {
        Connection connection = connectionDB.register();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_CF);
        preparedStatement.setString(1, cf);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Document> documents = new ArrayList<>();
        while (resultSet.next()) {
            Document document = new Document();
            document.setIdDoc(resultSet.getInt("idDoc"));
            document.setNameFile(resultSet.getString("nameFile"));
            document.setTypeOfFile(TypeOfFile.valueOf(resultSet.getString("typeOfFile")));
            document.setTypeOfDoc(TypeOfDoc.valueOf(resultSet.getString("typeOfDoc")));
            document.setDataOfInput(resultSet.getDate("dataOfInput").toLocalDate());
            document.setFile(resultSet.getString("file"));
            document.setFiscalCode(resultSet.getString("fiscalCode"));
            documents.add(document);
        } return documents;
    }

    @Override
    public Optional<Document> find(Integer id) throws SQLException {
        Connection connection = connectionDB.register();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Document document = new Document();
            document.setIdDoc(resultSet.getInt("idDoc"));
            document.setNameFile(resultSet.getString("nameFile"));
            document.setTypeOfFile(TypeOfFile.valueOf(resultSet.getString("typeOfFile")));
            document.setTypeOfDoc(TypeOfDoc.valueOf(resultSet.getString("typeOfDoc")));
            document.setDataOfInput(resultSet.getDate("dataOfInput").toLocalDate());
            document.setFile(resultSet.getString("file"));
            document.setFiscalCode(resultSet.getString("fiscalCode"));
            return Optional.of(document);
        } return null;
    }

    @Override
    public List<Document> findAll() throws SQLException {
        Connection connection = connectionDB.register();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL);
        List<Document> documents = new ArrayList<>();
        while (resultSet.next()) {
            Document document = new Document();
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
    public void delete(Integer id) throws SQLException {
        Connection connection = connectionDB.register();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

    }
}