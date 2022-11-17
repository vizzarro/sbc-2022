package it.aesys.courses.springboot.dao;

import org.springframework.stereotype.Component;

@Component
public class PersonDao {
    private static final String DRIVER_NAME = " da mettere ";
    private static final String SQLSelect = "SELECT * FROM person WHERE fiscalCodeNumber=?";
    private static final String SQLInsert = "INSERT INTO person (fiscalCodeNumber) VALUE('?')";
    private static final String SQLDelete = "DELETE FROM person WHERE fiscalCodeNumber='?'";

}
