package it.aesys.courses.springboot.service;

import it.aesys.courses.springboot.exception.BadInputException;
import it.aesys.courses.springboot.model.Report;
import it.aesys.courses.springboot.model.mapperDTO.ReportDtoRequest;
import it.aesys.courses.springboot.model.mapperDTO.ReportDtoResponse;

import java.util.List;

public interface ReportService {
    ReportDtoRequest create(ReportDtoRequest dto);
    List<Report> getPersonHistory(String fiscalCodeNumber);
    void delete (Integer reportTicketNumber) throws BadInputException;
    ReportDtoResponse update(Integer reportTicketNumber, ReportDtoResponse updatedDto) throws BadInputException;
    boolean canBorrow(String fiscalCodeNumber);
}