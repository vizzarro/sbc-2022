package it.aesys.courses.springboot.personregistry.dao.impl;

import it.aesys.courses.springboot.personregistry.dao.AddressDao;
import it.aesys.courses.springboot.personregistry.models.Address;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class AddressDaoImpl implements AddressDao {


    String dbURL = "jdbc:mysql://localhost:3306/personregistrydb";
    String username = "root";
    String password = "secret";

    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";


    private static final String INSERT_ADDRESS_SQL = "INSERT INTO address" +
            "  ( street, civic, postalCode, home ) VALUES " +
            " ( ?, ?, ?, ? )";

    @Override
    public Address create(Address address) {
        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADDRESS_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, address.getStreet());
            preparedStatement.setString(2, address.getCivic());
            preparedStatement.setInt(3, address.getPostalCode());
            preparedStatement.setString(4, address.getHome().name());

            preparedStatement.executeUpdate();

           ResultSet rs = preparedStatement.getGeneratedKeys();
           while (rs.next()){
               address.setAddress_id(rs.getInt(1));
           }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return address;
    }

    @Override
    public Address update(Address address) {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Address get(String s) {
        return null;
    }

    @Override
    public List<Address> getAll() {
        return null;
    }
}