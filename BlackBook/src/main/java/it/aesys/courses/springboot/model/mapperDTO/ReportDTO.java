package it.aesys.courses.springboot.model.mapperDTO;

import it.aesys.courses.springboot.model.ProblemType;

public class ReportDTO {

    private Integer reportTicketNumber;
    private ProblemType problemType;
    private String problemDescription;

    public ReportDTO() {
    }

    public Integer getReportTicketNumber() {
        return reportTicketNumber;
    }

    public void setReportTicketNumber(Integer reportTicketNumber) {
        this.reportTicketNumber = reportTicketNumber;
    }

    public ProblemType getProblemType() {
        return problemType;
    }

    public void setProblemType(ProblemType problemType) {
        this.problemType = problemType;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }
}
