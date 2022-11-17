package it.aesys.courses.springboot.service.impl;

import it.aesys.courses.springboot.dao.ReportDao;
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
    public ReportServiceImpl(ReportDao reportDao, ReportMapperDTO mapper){
        this.reportDao = reportDao;
        this.mapper = mapper;
    }


    @Override
    public ReportDtoRequest create(ReportDtoRequest dto) {
        return this.mapper.toRequestDto(this.reportDao.addReport(this.mapper.toRequestModel(dto)));
    }

    @Override
    public List<Report> getPersonHistory(String fiscalCodeNumber) {
        return this.reportDao.getReport(fiscalCodeNumber);
    }

    @Override
    public void delete(Integer reportTicketNumber) {
        this.reportDao.deleteReport(reportTicketNumber);
    }

    @Override
    public ReportDtoResponse update(Integer reportTicketNumber, ReportDtoResponse updatedDto) {
        return this.mapper.toResponseDto(this.reportDao.updateReport(this.mapper.toResponseModel(updatedDto)));
    }

    @Override
    public boolean canBorrow(String fiscalCodeNumber) {
        return false;
    }
}
