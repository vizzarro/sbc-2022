package it.aesys.courses.springboot.personregistry.daoImpl;

import it.aesys.courses.springboot.personregistry.dao.AddressDao;
import it.aesys.courses.springboot.personregistry.models.Address;
import it.aesys.courses.springboot.personregistry.models.Person;

import java.sql.*;

import static it.aesys.courses.springboot.personregistry.daoImpl.DaoImpl.printSQLException;

public class DaoAddressImpl implements AddressDao {


    String dbURL = "jdbc:mysql://localhost:3306/personregistrydb";
    String username = "root";
    String password = "secret";

    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";


    private static final String INSERT_ADDRESS_SQL = "INSERT INTO address" +
            "  ( street, civic, postalCode, home ) VALUES " +
            " ( ?, ?, ?, ? );";
    private static final String GET_ADDRESS_SQL = "SELECT * FROM persons WHERE address_ID = " +
            "  ( street, civic, postalCode, home ) VALUES " +
            " ( ?, ?, ?, ? );";


    public Address create(Address address) throws SQLException, ClassNotFoundException {
        System.out.println(INSERT_ADDRESS_SQL);
        // Step 1: Establishing a Connection
        try {
            Class.forName(DRIVER_NAME);

            Connection connection = DriverManager
                    .getConnection(dbURL, username, password);

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADDRESS_SQL);
            preparedStatement.setString(1, address.getStreet());
            preparedStatement.setString(2, address.getCivic());
            preparedStatement.setInt(3, address.getPostalCode());
            preparedStatement.setString(4, address.getHome().name());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
        return address;
    }

    public Person getAddress(int address_Id) throws SQLException {
        System.out.println(GET_ADDRESS_SQL);
        // Step 1: Establishing a Connection
        try {
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false", "root", "root");


            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ADDRESS_SQL);


            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query

            ResultSet rs = preparedStatement.executeQuery();

        } catch (SQLException e) {

            // print SQL exception information
            printSQLException(e);
        }

//
//        public void printSQLException(SQLException se) {
//            for (Throwable e: ex) {
//                if (e instanceof SQLException) {
//                    e.printStackTrace(System.err);
//                    System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                    System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                    System.err.println("Message: " + e.getMessage());
//                    Throwable t = ex.getCause();
//                    while (t != null) {
//                        System.out.println("Cause: " + t);
//                        t = t.getCause();
//                    }
//                }
//            }
//        return null;

