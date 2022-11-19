package it.aesys.courses.springboot.personregistry.dao.impl;

import it.aesys.courses.springboot.personregistry.dao.AddressDao;
import it.aesys.courses.springboot.personregistry.dao.Dao;
import it.aesys.courses.springboot.personregistry.dao.exception.DaoException;
import it.aesys.courses.springboot.personregistry.models.Address;
import it.aesys.courses.springboot.personregistry.models.EnumAddress;
import it.aesys.courses.springboot.personregistry.models.EnumGender;
import it.aesys.courses.springboot.personregistry.models.Person;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AddressDaoImpl implements AddressDao {


//    String dbURL = "jdbc:mysql://192.168.130.6:3306/";
//    String username = "user_library";
//    String password = "password";
//TODO SOSTITUIRE I DATI CON DATABASE LOCALE
    String dbURL = "jdbc:mysql://127.0.0.1:3306/librarydb";
    String username = "root";
    String password = "Admin";

    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String INSERT_ADDRESS_SQL = "INSERT INTO address" +
            "  ( street, civic, postalCode, home ) VALUES " +
            " ( ?, ?, ?, ? )";
    private static final String UPDATE_ADDRESS_SQL = "UPDATE address SET " +
            "( street = ?, civic = ?, postalCode = ?, home = ?  WHERE address_id = ?)";
    private static final String GET_ALL_ADDRESS_SQL = "SELECT * FROM address";
    private static final String GET_ADDRESS_SQL = "SELECT address_id FROM address WHERE address_id =  ?";
    private static final String DELETE_ADDRESS_SQL = "DELETE FROM address WHERE address_id = ?";

    @Override
    public Integer createAddress(Address address) {
        PreparedStatement preparedStatement = null;
        Integer addressId = null;
        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            preparedStatement = connection.prepareStatement(INSERT_ADDRESS_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, address.getStreet());
            preparedStatement.setString(2, address.getCivic());
            preparedStatement.setInt(3, address.getPostalCode());
            preparedStatement.setString(4, address.getHome().name());
            System.out.println(preparedStatement);
            preparedStatement.execute();

           ResultSet rs = preparedStatement.getGeneratedKeys();
           while (rs.next()){

               addressId = (rs.getInt(1));
           }



        } catch (ClassNotFoundException e) {
            DaoException exc = new DaoException();
            exc.setMessage("Driver not found!");
        } catch (SQLException e) {
            DaoException exc = new DaoException();
            exc.setMessage("not found");;
        }
        if (addressId != null) {
            return addressId;
        }
        else
            //TODO throw new SQLException();
        return null;
    }



    @Override
    public Address update(Address address) throws DaoException {


        if (get(address.getAddressId().toString()) != null) {

            try {
                Class.forName(DRIVER_NAME);
                Connection connection = DriverManager
                        .getConnection(dbURL, username, password);

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ADDRESS_SQL);
                preparedStatement.setString(1, address.getStreet());
                preparedStatement.setString(2, address.getCivic());
                preparedStatement.setInt(3, address.getPostalCode());
                preparedStatement.setString(4, address.getHome().name());

                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                preparedStatement.execute();


                return address;

            } catch (SQLException e) {
                // print SQL exception information
                printSQLException(e);
                DaoException exc = new DaoException();
                exc.setMessage("Already existing");

            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
                DaoException exc = new DaoException();
                exc.setMessage("Driver not found");

                throw exc;
            }
        }
        DaoException excep = new DaoException();
        excep.setMessage("Address is null!");
        throw excep;
    }



    @Override
    public void deleteAddress(Integer index) throws DaoException {

        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager
                    .getConnection(dbURL, username, password);

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ADDRESS_SQL);
            preparedStatement.setInt(1, index);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.execute();

        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
            DaoException exc = new DaoException();
            exc.setMessage("not found");
        } catch (ClassNotFoundException ex) {
            //ex.printStackTrace();
            DaoException excep = new DaoException();
            excep.setMessage("Driver not found!");
            throw excep;
        }
    }







    public Address getAddress(Integer index) throws DaoException {

        Address a = null;
        System.out.println(GET_ADDRESS_SQL);
        // Step 1: Establishing a Connection
        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager
                    .getConnection(dbURL, username, password);


            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ADDRESS_SQL);
            preparedStatement.setInt(1, index);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                a = new Address();
                a.setStreet(rs.getString("street"));
                a.setCivic(rs.getString("civic"));
                a.setPostalCode(rs.getInt("postalCode"));
                a.setHome(EnumAddress.valueOf(rs.getString("home")));
            }

        } catch (SQLException e) {

            // print SQL exception information
            printSQLException(e);
            DaoException exc = new DaoException();
            exc.setMessage("not found");
        } catch (ClassNotFoundException e) {
            DaoException exc = new DaoException();
            exc.setMessage("Driver Not Found!");
            throw exc;
        }
        return a;



    }



    @Override
    public List<Address> getAll() throws DaoException {

        List<Address> addressList = new ArrayList<>();

        // Step 1: Establishing a Connection
        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager
                    .getConnection(dbURL, username, password);


            // Step 2:Create a statement using connection object
            Statement statement = connection.createStatement();


            // Step 3: Execute the query or update query

            ResultSet rs = statement.executeQuery(GET_ALL_ADDRESS_SQL);

            //TODO ciclare il rs per prendere i campi e settarlo nella entity
            while (rs.next()) {
                Address a = new Address();
                a.setStreet(rs.getString("street"));
                a.setCivic(rs.getString("civic"));
                a.setPostalCode(rs.getInt("postalCode"));
                a.setHome(EnumAddress.valueOf(rs.getString("home")));;
                addressList.add(a);
            }

        } catch (SQLException e) {

            // print SQL exception information
            printSQLException(e);

            DaoException ex = new DaoException();
            ex.setMessage("SQL Error, Address not found");
            throw ex;
        } catch (ClassNotFoundException e) {
             DaoException exc = new DaoException();
            exc.setMessage("Driver not found!");
            throw exc;
        }
        return addressList;
    }


    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    @Override
    public void delete(String s) throws DaoException {
        //NON USARE
    }

    @Override
    public Address get(String s) throws DaoException {
        // NON USARE

        return null;
    }
    @Override
    public Address create(Address address) throws DaoException {
        // VECCHIO CREATE, SPERIMENTO CON RETURN INTEGER
        return null;
    }


}