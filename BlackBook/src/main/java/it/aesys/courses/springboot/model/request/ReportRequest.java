package it.aesys.courses.springboot.model.request;

import it.aesys.courses.springboot.model.Person;
import it.aesys.courses.springboot.model.Report;

public class ReportRequest {
    private Report report;

    public ReportRequest() {
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
