package it.aesys.courses.springboot.connections;

import org.springframework.stereotype.Component;
import java.sql.*;
@Component
public class DBManager {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    public void register(){
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public Connection connection(){
        Connection connectiondb = null;
        try{
        connectiondb = DriverManager.getConnection("jdbc:mysql://192.168.130.6:3306/library", "user_library","password");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return connectiondb;
    }
}
