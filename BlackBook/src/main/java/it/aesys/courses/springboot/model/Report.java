package it.aesys.courses.springboot.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name="report")

public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="report_ticket_number")
    private Integer reportTicketNumber;
    @Column(name="problem_type", columnDefinition="enum('NONPAYMENT','PROPERTY_DAMAGED','FAILURE_TO_RETURN','OTHER')")
    @Enumerated(EnumType.STRING)
    private ProblemType problemType;
    @Column(name="problem_description")

    private String problemDescription;
    @Column(name="fiscal_code_number")
    private String fiscalCodeNumber;

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