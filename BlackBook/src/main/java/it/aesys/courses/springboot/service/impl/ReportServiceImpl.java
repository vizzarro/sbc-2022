package it.aesys.courses.springboot.service.impl;

import it.aesys.courses.springboot.dao.ReportDao;
import it.aesys.courses.springboot.exception.BadInputException;
import it.aesys.courses.springboot.exception.PersonHistoryNotFoundException;
import it.aesys.courses.springboot.model.Report;
import it.aesys.courses.springboot.model.mapperDTO.ReportDtoRequest;
import it.aesys.courses.springboot.model.mapperDTO.ReportDtoResponse;
import it.aesys.courses.springboot.model.mapperDTO.ReportMapperDTO;
import it.aesys.courses.springboot.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    private ReportDao reportDao;

    private ReportMapperDTO mapper;

    @Autowired
    public ReportServiceImpl(ReportDao reportDao, ReportMapperDTO mapper) {
        this.reportDao = reportDao;
        this.mapper = mapper;
    }


    @Override
    public ReportDtoRequest create(ReportDtoRequest dto) throws BadInputException {
        if(dto.getFiscalCodeNumber().length() == 16 && dto.getProblemDescription().length() < 100) {
            return this.mapper.toRequestDto(this.reportDao.addReport(this.mapper.toRequestModel(dto)));
        } else {
            throw new BadInputException("Bad Input.");
        }
    }

    @Override
    public List<Report> getPersonHistory(String fiscalCodeNumber) throws PersonHistoryNotFoundException {
        if(reportDao.getReport(fiscalCodeNumber).isEmpty()) {
            return this.reportDao.getReport(fiscalCodeNumber);
        } else {
            throw new PersonHistoryNotFoundException("No history availible, required person is clean!");
        }
    }


    @Override
    public void delete(Integer reportTicketNumber) throws BadInputException {
        if (reportDao.getReportByTicket(reportTicketNumber) != null) {
            this.reportDao.deleteReport(reportTicketNumber);
        } else {
            throw new BadInputException("Invalid Input: Ticket not found");
        }
    }


    @Override
    public ReportDtoResponse update(Integer reportTicketNumber, ReportDtoResponse updatedDto) throws BadInputException {
        if(reportDao.getReportByTicket(updatedDto.getReportTicketNumber()) != null) {
            return this.mapper.toResponseDto(this.reportDao.updateReport(this.mapper.toResponseModel(updatedDto)));
        } else {
            throw new BadInputException("Invalid Input: ticket not found");
        }
    }
}
