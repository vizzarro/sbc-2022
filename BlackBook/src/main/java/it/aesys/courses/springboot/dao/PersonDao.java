package it.aesys.courses.springboot.dao;

import com.mysql.cj.jdbc.Driver;
import org.springframework.stereotype.Component;

@Component
public class PersonDao {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String SQLSelect = "SELECT fiscalCode FROM person WHERE fiscalCode=?";




}
