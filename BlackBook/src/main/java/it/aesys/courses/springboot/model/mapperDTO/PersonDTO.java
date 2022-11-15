package it.aesys.courses.springboot.model.mapperDTO;

import it.aesys.courses.springboot.model.Report;

import java.util.List;

public class PersonDTO {

    private String fiscalCodeNumber;

    private List<Report> reports;
    private boolean evaluationResult;

    public PersonDTO() {
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

    public boolean isEvaluationResult() {
        return evaluationResult;
    }

    public void setEvaluationResult(boolean evaluationResult) {
        this.evaluationResult = evaluationResult;
    }
}
