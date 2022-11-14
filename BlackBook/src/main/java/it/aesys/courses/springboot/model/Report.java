package it.aesys.courses.springboot.model;

public class Report {

    private Problem problemType;
    private String reportDescription;

    public Report(){

    }

    public Report(Problem problemType, String reportDescription) {
        this.problemType = problemType;
        this.reportDescription = reportDescription;
    }

    public Problem getProblemType() {
        return problemType;
    }

    public void setProblemType(Problem problemType) {
        this.problemType = problemType;
    }

    public String getReportDescription() {
        return reportDescription;
    }

    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }
}
