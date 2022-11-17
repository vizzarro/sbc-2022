package it.aesys.courses.springboot.dao;

import it.aesys.courses.springboot.model.ProblemType;
import it.aesys.courses.springboot.model.Report;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReportDao {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String SQLSelect = "SELECT * FROM report WHERE fiscalCodeNumber=?";
    private static final String SQLInsert = "INSERT INTO report (problemType,problemDescription,fiscalCodeNumber) VALUE(?,?,?)";
    private static final String SQLUpdate = "UPDATE report SET problemType=?,problemDescription=?,fiscalCodeNumber=? WHERE reportTicketNumber=?";
    private static final String SQLDelete = "DELETE FROM report WHERE reportTicketNumber=?";


    public List<Report> getReport(String fiscalCodeNumber) {
        List<Report> reportList = new ArrayList<>();
        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.130.6:3306/library", "user_library","password");
            PreparedStatement preparedStatement = connection.prepareStatement(SQLSelect);
            preparedStatement.setString(1, fiscalCodeNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Report report = new Report();
                report.setReportTicketNumber(resultSet.getInt("reportTicketNumber"));
                report.setProblemType(ProblemType.valueOf(resultSet.getString("problemType")));
                report.setProblemDescription(resultSet.getString("problemDescription"));
                report.setFiscalCodeNumber(resultSet.getString("fiscalCodeNumber"));
                reportList.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return reportList;
    }

    public Report addReport(Report report) {
        Connection connection = null;
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection("jdbc:mysql://192.168.130.6:3306/library", "user_library","password");
            PreparedStatement preparedStatement = connection.prepareStatement(SQLInsert);

            preparedStatement.setString(1, report.getProblemType().name()); //DEBUG IL .NAME
            preparedStatement.setString(2, report.getProblemDescription());
            preparedStatement.setString(3, report.getFiscalCodeNumber());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return report;
    }

    public Report updateReport(Report report) {
        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.130.6:3306/library","user_library","password");
            PreparedStatement preparedStatement = connection.prepareStatement(SQLUpdate);
            preparedStatement.setString(1, report.getProblemType().name());
            preparedStatement.setString(2, report.getProblemDescription());
            preparedStatement.setString(3, report.getFiscalCodeNumber());
            preparedStatement.setInt(4, report.getReportTicketNumber());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return report;
    }
    public void deleteReport(Integer ticketReportNumber){
        try {
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.130.6:3306/library", "user_library","password");
            PreparedStatement preparedStatement = connection.prepareStatement(SQLDelete);
            preparedStatement.setInt(1, ticketReportNumber);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}