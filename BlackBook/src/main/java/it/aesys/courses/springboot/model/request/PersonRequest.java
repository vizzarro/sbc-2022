package it.aesys.courses.springboot.model.request;

import it.aesys.courses.springboot.model.Person;
import it.aesys.courses.springboot.model.Report;

public class PersonRequest {
    private String fiscalCode;
    private Report report;

    public PersonRequest() {
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }
}
