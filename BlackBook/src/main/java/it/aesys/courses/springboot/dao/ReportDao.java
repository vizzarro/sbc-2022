package it.aesys.courses.springboot.dao;
import org.springframework.stereotype.Component;

import java.sql.*;
@Component
public class ReportDao{
        private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
        private static final String SQLSelect = "SELECT * FROM report WHERE reportTicketNumber=?";
        private static final String SQLInsert = "INSERT INTO report (reportTicketNumber,problemType,problemDescription,fiscalCodeNumber) VALUE('?','?';'?','?')";
        private static final String SQLUpdate = "UPDATE report SET problemType='?',problemDescription='?' WHERE reportTicketNumber='?'";
        private static final String SQLDelete = "DELETE FROM report WHERE reportTicketNumber='?'";


}
