package it.aesys.courses.springboot.service;

import it.aesys.courses.springboot.model.Report;
import it.aesys.courses.springboot.model.mapperDTO.ReportDtoRequest;
import it.aesys.courses.springboot.model.mapperDTO.ReportDtoResponse;

import java.util.List;

public interface ReportService {
    ReportDtoRequest create(ReportDtoRequest dto);
    List<Report> getPersonHistory(String fiscalCodeNumber);
    void delete (Integer reportTicketNumber);
    ReportDtoResponse update(Integer reportTicketNumber, ReportDtoResponse updatedDto);
    boolean canBorrow(String fiscalCodeNumber);
}