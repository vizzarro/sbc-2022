package it.aesys.courses.springboot.service.impl;


import it.aesys.courses.springboot.model.Report;
import it.aesys.courses.springboot.model.mapperDTO.ReportDtoRequest;
import it.aesys.courses.springboot.model.mapperDTO.ReportDtoResponse;
import it.aesys.courses.springboot.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {


    @Override
    public ReportDtoResponse create(ReportDtoRequest dto) {
        return null;
    }

    @Override
    public List<Report> getPersonHistory(String fiscalCodeNumber) {
        return null;
    }

    @Override
    public void delete(Integer reportTicketNumber) {

    }

    @Override
    public ReportDtoResponse update(Integer reportTicketNumber, ReportDtoRequest updatedDto) {
        return null;
    }

    @Override
    public boolean canBorrow(String fiscalCodeNumber) {
        return false;
    }
}
