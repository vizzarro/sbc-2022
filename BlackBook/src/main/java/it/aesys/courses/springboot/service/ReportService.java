package it.aesys.courses.springboot.service;

import it.aesys.courses.springboot.model.Report;

import java.util.List;


public interface ReportService {

    List<Report> getCriminalRecord (String fiscalCodeNumber);
    void addReport(String fiscalCodeNumber, Report report);
    void updateReport(String fiscalCodeNumber, Report report);

}
