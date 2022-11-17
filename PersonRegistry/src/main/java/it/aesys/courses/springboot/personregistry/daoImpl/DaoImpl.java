package it.aesys.courses.springboot.personregistry.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DaoImpl {

    String dbURL = "jdbc:mysql://localhost:3306/personregistrydb";
    String username = "root";
    String password = "secret";

    private static final String INSERT_PERSONS_SQL = "INSERT INTO persons" +
            "  (id, name, surname, fiscalcode, gender, address, birthdate, cellnumber, ) VALUES " +
            " (?, ?, ?, ?, ? , ? , ? , ?);";

//try { (Connection conn = DriverManager.getConnection(dbURL, username, password))
//
//
//        if (conn != null) {
//            System.out.println("Connected");
//        }
//    } catch (
//    SQLException ex) {
//        ex.printStackTrace();
//    }
//        }

        public void insertPerson() throws SQLException {
            System.out.println(INSERT_PERSONS_SQL);
            // Step 1: Establishing a Connection
            try (Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false", "root", "root");

                 // Step 2:Create a statement using connection object
                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PERSONS_SQL)) {
                preparedStatement.setInt(1, 1);
                preparedStatement.setString(2, "Tony");
                preparedStatement.setString(3, "tony@gmail.com");
                preparedStatement.setString(4, "US");
                preparedStatement.setString(5, "secret");

                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                preparedStatement.executeUpdate();
            } catch (SQLException e) {

                // print SQL exception information
                printSQLException(e);
            }

            // Step 4: try-with-resource statement will auto close the connection.
        }

        public static void printSQLException(SQLException ex) {
            for (Throwable e: ex) {
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
    }







}
