package it.aesys.courses.springboot.utils.connectionDb;
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

    public void register(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/DocumentsRepo",user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
