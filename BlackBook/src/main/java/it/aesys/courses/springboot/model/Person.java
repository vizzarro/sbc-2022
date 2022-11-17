package it.aesys.courses.springboot.model;

import java.util.List;

public class Person {
    private String fiscalCodeNumber;
    private List<Report> reports;
    public Person() {
    }

    public Person(String fiscalCodeNumber) {
        this.fiscalCodeNumber = fiscalCodeNumber;
    }

    public Person(String fiscalCodeNumber, List<Report> reports) {
        this.fiscalCodeNumber = fiscalCodeNumber;
        this.reports = reports;
    }

    public void setFiscalCodeNumber(String fiscalCodeNumber) {
        this.fiscalCodeNumber = fiscalCodeNumber;
    }

    public String getFiscalCodeNumber() {
        return fiscalCodeNumber;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

}
