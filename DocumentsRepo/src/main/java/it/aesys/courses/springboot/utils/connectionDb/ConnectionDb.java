package it.aesys.courses.springboot.utils.connectionDb;
import com.mysql.cj.jdbc.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class ConnectionDb {

    @Value("${jdbc.user}")
    private String user;
    @Value("${jdbc.password}")
    private String password;
    @Value("${jdbc.url}")
    private String url;

    public Connection register(){
        try {
            Driver driver = new Driver();
            Connection connection = DriverManager.getConnection(url,user, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
