package it.aesys.courses.springboot.service.impl;

import it.aesys.courses.springboot.dao.ReportDao;
import it.aesys.courses.springboot.exception.BadInputException;
import it.aesys.courses.springboot.exception.PersonHistoryNotFoundException;
import it.aesys.courses.springboot.model.Report;
import it.aesys.courses.springboot.model.mapperDTO.ReportDtoRequest;
import it.aesys.courses.springboot.model.mapperDTO.ReportDtoResponse;
import it.aesys.courses.springboot.model.mapperDTO.ReportMapperDTO;
import it.aesys.courses.springboot.repository.BlackBookRepository;
import it.aesys.courses.springboot.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {
    //private ReportDao reportDao;


    BlackBookRepository blackBookRepository;

    private ReportMapperDTO mapper;

    @Autowired
    public ReportServiceImpl(BlackBookRepository blackBookRepository, ReportMapperDTO mapper) {
        this.blackBookRepository = blackBookRepository;
        this.mapper = mapper;
    }


    @Override
    @Transactional
    public ReportDtoRequest create(ReportDtoRequest dto) throws BadInputException {
        if(dto.getFiscalCodeNumber().length() == 16 && dto.getProblemDescription().length() < 100) {
            return this.mapper.toRequestDto(this.blackBookRepository.save(this.mapper.toRequestModel(dto)));
        } else {
            throw new BadInputException("Bad Input.");
        }
    }

    @Override
    public List<Report> getPersonHistory(String fiscalCodeNumber) throws PersonHistoryNotFoundException {
        List<Report> personHistory = blackBookRepository.findAllByFiscalCodeNumber(fiscalCodeNumber);

        if(personHistory.isEmpty()) {
            throw new PersonHistoryNotFoundException("No history availible, required person is clean!");
        }
        return personHistory;
    }


    @Override
    @Transactional
    public void delete(Integer reportTicketNumber) throws BadInputException {

        Optional<Report> reportToBeDeleted = blackBookRepository.findById(reportTicketNumber);

        if (reportToBeDeleted.isEmpty()) {
            throw new BadInputException("Invalid Input: Ticket not found");
        }
        blackBookRepository.delete(reportToBeDeleted.get());
    }


    @Override
    public ReportDtoResponse update(Integer reportTicketNumber, ReportDtoRequest updatedDto) throws BadInputException {

        Optional<Report> reportOptional = blackBookRepository.findById(reportTicketNumber);

        if(reportOptional.isEmpty()) {
            throw new BadInputException("Invalid Input: ticket not found");
        }
    Report oldReport = reportOptional.get();
    Report reportToUpdate= mapper.toRequestModel(updatedDto);
    reportToUpdate.setReportTicketNumber(oldReport.getReportTicketNumber());

    Report report = blackBookRepository.save(reportToUpdate);
    return mapper.toResponseDto(report);

    }
}
