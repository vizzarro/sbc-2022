package it.aesys.courses.springboot.model;

public class Report {

    private Integer reportTicketNumber;
    private ProblemType problemType;
    private String problemDescription;
    private  String fiscalCodeNumber;

    public Report() {
    }

    public ProblemType getProblemType() {
        return problemType;
    }

    public void setProblemType(ProblemType problemType) {
        this.problemType = problemType;
    }

    public Integer getReportTicketNumber() {
        return reportTicketNumber;
    }

    public void setReportTicketNumber(Integer reportTicketNumber) {
        this.reportTicketNumber = reportTicketNumber;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getFiscalCodeNumber() {
        return fiscalCodeNumber;
    }

    public void setFiscalCodeNumber(String fiscalCodeNumber) {
        this.fiscalCodeNumber = fiscalCodeNumber;
    }
}
