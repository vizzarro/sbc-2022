package it.aesys.courses.springboot.service.impl;


import it.aesys.courses.springboot.model.mapperDTO.ReportDTO;
import it.aesys.courses.springboot.service.ReportService;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {


    @Override
    public ReportDTO create(ReportDTO dto) {

        return null;
    }
    @Override
    public ReportDTO getPersonHistory(String fiscalCodeNumber) {
        return null;
    }
    @Override
    public ReportDTO getReportTicket(String reportTicketNumber) {return null;}

    @Override
    public ReportDTO delete(String reportTicketNumber) {
        return null;
    }

    @Override
    public ReportDTO update(ReportDTO dto) {
        return null;
    }

    @Override
    public boolean canBorrow(ReportDTO dto) {
        return false;
    }
}
