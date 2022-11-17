package it.aesys.courses.springboot.personregistry.dao.impl;

import it.aesys.courses.springboot.personregistry.dao.PersonDao;
import it.aesys.courses.springboot.personregistry.models.EnumGender;
import it.aesys.courses.springboot.personregistry.models.Person;

import java.sql.*;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

    String dbURL = "jdbc:mysql://192.168.130.6:3306/";
    String username = "user_library";
    String password = "password";
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    private static final String INSERT_PERSONS_SQL = "INSERT INTO persons" +
            "  ( name, surname, fiscalcode, gender, address, birthdate, cellnumber, ) VALUES " +
            " ( ?, ?, ?, ? , ? , ? , ?);";
    private static final String GET_PERSONS_SQL = "SELECT fiscalcode FROM persons WHERE fiscalcode =  ?";

    @Override
    public Person create(Person person) throws SQLException {

        System.out.println(INSERT_PERSONS_SQL);
        // Step 1: Establishing a Connection
        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager
                    .getConnection(dbURL, username, password);

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PERSONS_SQL);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getSurname());
            preparedStatement.setString(3, person.getFiscalCode());
            preparedStatement.setString(4, person.getGender().name());
            preparedStatement.setDate(6, (Date) person.getBirthDate());
            preparedStatement.setString(7, person.getCellNumber());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.execute();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        } catch (ClassNotFoundException ex) {

        }

        // Step 4: try-with-resource statement will auto close the connection.
        return person;
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
    public Person update(Person person) {



        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public Person get(String s) {
        Person p = null;
        System.out.println(GET_PERSONS_SQL);
        // Step 1: Establishing a Connection
        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager
                    .getConnection(dbURL, username, password);


            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PERSONS_SQL);
            preparedStatement.setString(1, s);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query

            ResultSet rs = preparedStatement.executeQuery();

            //TODO ciclare il rs per prendere i campi e settarlo nella entity
            while (rs.next()) {
                p.setName(rs.getString("name"));
                p.setSurname(rs.getString("surname"));
                p.setFiscalCode(rs.getString("fiscalcode"));
                p.setGender(EnumGender.valueOf(rs.getString("gender")));

                p.setBirthDate(rs.getDate("birth_date"));
                p.setCellNumber(rs.getString("cellnumber"));

            }

        } catch (SQLException e) {

            // print SQL exception information
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    @Override
    public List<Person> getAll() {
        return null;
    }
}
