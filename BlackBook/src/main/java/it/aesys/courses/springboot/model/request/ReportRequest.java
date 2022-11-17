package it.aesys.courses.springboot.model.request;

import it.aesys.courses.springboot.model.mapperDTO.ReportDTO;

public class ReportRequest {
    private ReportDTO reportDTO = new ReportDTO();

    public ReportRequest() {
        super();
    }

    public ReportDTO getReportDTO() {
        return reportDTO;
    }

    public void setReportDTO(ReportDTO reportDTO) {
        this.reportDTO = reportDTO;
    }
}
