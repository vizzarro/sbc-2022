package it.aesys.courses.springboot.personregistry.dao.impl;

import it.aesys.courses.springboot.personregistry.dao.PersonDao;
import it.aesys.courses.springboot.personregistry.dao.exception.DaoException;
import it.aesys.courses.springboot.personregistry.models.Address;
import it.aesys.courses.springboot.personregistry.models.EnumAddress;
import it.aesys.courses.springboot.personregistry.models.EnumGender;
import it.aesys.courses.springboot.personregistry.models.Person;
import it.aesys.courses.springboot.personregistry.service.exceptions.ServiceException;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class PersonDaoImpl implements PersonDao {

//    String dbURL = "jdbc:mysql://192.168.130.6:3306/";
//    String username = "user_library";
//    String password = "password";
//TODO SOSTITUIRE I DATI CON DATABASE LOCALE



    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    private static final String INSERT_PERSONS_SQL = "INSERT INTO person" +
            "  ( name, surname, fiscalcode, gender, address_id, birth_date, cell_number ) VALUES " +
            " ( ?, ?, ?, ? , ? , ?, ?);";
    private static final String GET_PERSONS_SQL = "SELECT fiscalcode FROM person WHERE fiscalcode =  ?";

    //GET ALL CORRETTA, CONTROLLARE, LA JOIN DA SOLO UN RECORD

    private static final String GET_ALL_SQL ="SELECT * FROM librarydb.address as a, librarydb.person as p "+
"WHERE  p.address_id = a.address_id";
//JOIN
//            "SELECT *\n" +
//                    "from librarydb.person as p\n" +
//                    "inner join librarydb.address as a\n" +
//                    "on a.address_id=p.address_idn";



    private static final String UPDATE_PERSONS_SQL = "UPDATE person SET " +
            "( name = ?, surname = ?, fiscalcode = ?, gender = ?, address_id = ? ,birth_date = ?, cell_number = ?  WHERE fiscalcode = ?)";


    private static final String DELETE_PERSONS_SQL = "DELETE FROM person WHERE fiscalcode = ?";


    @Override
    public Person create(Person person) throws DaoException //throws SQLException
    {

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
            preparedStatement.setInt(5, person.getAddressId());
            preparedStatement.setDate(6, Date.valueOf(person.getBirthDate()));
            preparedStatement.setString(7, person.getCellNumber());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.execute();

        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
            DaoException exc = new DaoException();
            exc.setStatusCode(404);
            exc.setMessage("not found");

            throw exc;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new DaoException();
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
    public Person update(Person person) throws DaoException {

        if (get(person.getFiscalCode()) != null) {

            try {
                Class.forName(DRIVER_NAME);
                Connection connection = DriverManager
                        .getConnection(dbURL, username, password);

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PERSONS_SQL);
                preparedStatement.setString(1, person.getName());
                preparedStatement.setString(2, person.getSurname());

                preparedStatement.setString(4, person.getGender().name());
                preparedStatement.setDate(6, Date.valueOf(person.getBirthDate()));
                preparedStatement.setString(7, person.getCellNumber());

                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                preparedStatement.execute();


                return person;

            } catch (SQLException e) {
                // print SQL exception information
                printSQLException(e);
                DaoException exc = new DaoException();
                exc.setMessage("already existing");

            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
                throw new DaoException();
            }
        }
        //TODO Gestire eccezzione non può ritornare null
        return null;
    }

    @Override
    public void delete(String fiscalcode) throws DaoException {

        if (fiscalcode != null && get(fiscalcode) != null) {

            try {
                Class.forName(DRIVER_NAME);
                Connection connection = DriverManager
                        .getConnection(dbURL, username, password);

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PERSONS_SQL);
                preparedStatement.setString(1, fiscalcode);

                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                preparedStatement.execute();

            } catch (SQLException e) {
                // print SQL exception information
                printSQLException(e);
                DaoException exc = new DaoException();
                exc.setMessage("not found");
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
                throw new DaoException();
            }
        }

    }

    @Override
    public Person get(String s) throws DaoException {
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
                p = new Person();
                p.setName(rs.getString("name"));
                p.setSurname(rs.getString("surname"));
                p.setFiscalCode(rs.getString("fiscalcode"));
                p.setGender(EnumGender.valueOf(rs.getString("gender")));
                p.setAddressId(rs.getInt("address_id"));
                p.setBirthDate(rs.getDate("birth_date").toLocalDate());
                p.setCellNumber(rs.getString("cellnumber"));

            }

        } catch (SQLException e) {

            // print SQL exception information
            printSQLException(e);
            DaoException exc = new DaoException();
            exc.setMessage("not found");
        } catch (ClassNotFoundException e) {
            throw new DaoException();
        }
        return p;
    }

    @Override
    public List<Person> getAll() throws DaoException {
        List<Person> personList = new ArrayList<>();

        // Step 1: Establishing a Connection
        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager
                    .getConnection(dbURL, username, password);


            // Step 2:Create a statement using connection object
            Statement statement = connection.createStatement();


            // Step 3: Execute the query or update query

            ResultSet rs = statement.executeQuery(GET_ALL_SQL);

            //TODO ciclare il rs per prendere i campi e settarlo nella entity
            while (rs.next()) {
                Person p = new Person();
                p.setName(rs.getString("name"));
                p.setSurname(rs.getString("surname"));
                p.setFiscalCode(rs.getString("fiscalcode"));
                p.setGender(EnumGender.valueOf(rs.getString("gender")));
                p.setAddressId(rs.getInt("address_id"));
                p.setBirthDate(rs.getDate("birth_date").toLocalDate());
                p.setCellNumber(rs.getString("cell_number"));
                Address a = new Address();
                a.setStreet(rs.getString("street"));
                a.setCivic(rs.getString("civic"));
                a.setPostalCode(rs.getInt("postalcode"));
                a.setHome(EnumAddress.valueOf(rs.getString("home")) );
                p.setAddress(a);
                personList.add(p);
            }

        } catch (SQLException e) {

            // print SQL exception information
            printSQLException(e);
            throw new DaoException();
        } catch (ClassNotFoundException e) {
            throw new DaoException();
        }
        return personList;
    }
}
