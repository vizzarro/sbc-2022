package it.aesys.courses.springboot.service;

import it.aesys.courses.springboot.component.CriminalRecordComponent;
import it.aesys.courses.springboot.model.Report;

import java.util.List;


public interface CriminalRecordService {

    List<Report> getCriminalRecord (String fiscalCodeNumber);
    void addPerson(String fiscalCodeNumber);
    void addReport(String fiscalCodeNumber, Report report);

}
