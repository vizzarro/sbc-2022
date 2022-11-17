package it.aesys.courses.springboot.model.mapperDTO;

import it.aesys.courses.springboot.model.Report;

public class ReportMapperDTO {

    public ReportDTO toDto(Report report){

        ReportDTO dto = new ReportDTO();
        dto.setProblemType(report.getProblemType());
        dto.setProblemDescription(report.getProblemDescription());
        dto.setReportTicketNumber(report.getReportTicketNumber());

        return dto;
    }

    public Report toModel(ReportDTO dto){

        Report report = new Report();
        report.setProblemType(dto.getProblemType());
        report.setProblemDescription(dto.getProblemDescription());
        report.setReportTicketNumber(dto.getReportTicketNumber());

        return report;
    }

}
