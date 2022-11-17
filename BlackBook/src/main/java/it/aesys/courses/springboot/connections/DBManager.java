package it.aesys.courses.springboot.connections;

import org.springframework.stereotype.Component;

import java.sql.*;
@Component
public class DBManager {
    private static final String DRIVER_NAME = " da mettere ";
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
        connectiondb = DriverManager.getConnection("");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return connectiondb;
    }
}
