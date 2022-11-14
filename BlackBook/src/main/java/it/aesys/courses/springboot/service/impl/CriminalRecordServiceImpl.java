package it.aesys.courses.springboot.service.impl;

import it.aesys.courses.springboot.component.CriminalRecordComponent;
import it.aesys.courses.springboot.model.Report;
import it.aesys.courses.springboot.service.CriminalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriminalRecordServiceImpl implements CriminalRecordService {
    @Autowired
    private CriminalRecordComponent criminalRecordComponent;

    @Override
    public List<Report> getCriminalRecord(String fiscalCodeNumber) {
        return criminalRecordComponent.getReportList(fiscalCodeNumber);
    }

    @Override
    public void addPerson(String fiscalCodeNumber) {
        this.criminalRecordComponent.addNewPerson(fiscalCodeNumber);
    }

    @Override
    public void addReport(String fiscalCodeNumber, Report report) {
        this.criminalRecordComponent.addReport(fiscalCodeNumber, report);
    }

}
