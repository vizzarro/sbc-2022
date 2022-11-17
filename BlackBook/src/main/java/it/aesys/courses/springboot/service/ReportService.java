package it.aesys.courses.springboot.service;

import it.aesys.courses.springboot.model.mapperDTO.ReportDTO;

public interface ReportService {
    ReportDTO create(ReportDTO dto);
    ReportDTO getReportTicket(String reportTicketNumber);
    ReportDTO getPersonHistory(String fiscalCodeNumber);
    ReportDTO delete (String fiscalCodeNumber);
    ReportDTO update(ReportDTO dto);
    boolean canBorrow(ReportDTO dto);
}