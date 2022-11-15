package it.aesys.courses.springboot.model;

public class Report {

    private Integer reportTicket;
    private ProblemType problemType;
    private String problemDescription;

    public Report() {
    }

    public ProblemType getProblemType() {
        return problemType;
    }

    public void setProblemType(ProblemType problemType) {
        this.problemType = problemType;
    }

    public Integer getReportTicket() {
        return reportTicket;
    }

    public void setReportTicket(Integer reportTicket) {
        this.reportTicket = reportTicket;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

}
