package it.aesys.courses.springboot.service.impl;

import it.aesys.courses.springboot.component.ReportComponent;
import it.aesys.courses.springboot.model.Report;
import it.aesys.courses.springboot.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportComponent component;

    @Override
    public List<Report> getCriminalRecord(String fiscalCodeNumber) {
        return component.getReportList(fiscalCodeNumber);
    }

    @Override
    public void addReport(String fiscalCodeNumber, Report report) {
        this.component.addReport(fiscalCodeNumber, report);
    }

    @Override
    public void updateReport(String fiscalCodeNumber, Report report) {
        this.component.addNewReport(fiscalCodeNumber, report);
    }

}
