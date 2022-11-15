package it.aesys.courses.springboot.model;

public class Report {

    private ProblemType problemType;
    private String reportDescription;

    public Report(){

    }

    public Report(ProblemType problemType, String reportDescription) {
        this.problemType = problemType;
        this.reportDescription = reportDescription;
    }

    public ProblemType getProblemType() {
        return problemType;
    }

    public void setProblemType(ProblemType problemType) {
        this.problemType = problemType;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }
}
