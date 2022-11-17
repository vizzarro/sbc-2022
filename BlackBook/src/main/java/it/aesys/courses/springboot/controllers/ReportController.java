package it.aesys.courses.springboot.controllers;

import it.aesys.courses.springboot.exception.BadInputException;
import it.aesys.courses.springboot.model.Report;
import it.aesys.courses.springboot.model.mapperDTO.ReportDtoRequest;
import it.aesys.courses.springboot.model.mapperDTO.ReportDtoResponse;
import it.aesys.courses.springboot.model.request.ReportRequest;
import it.aesys.courses.springboot.model.request.ReportResponse;
import it.aesys.courses.springboot.service.impl.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("report")
public class ReportController {

    private ReportServiceImpl service;

    @Autowired
    public ReportController(ReportServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ReportDtoRequest create(@RequestBody ReportRequest request) {
        return service.create(request.getReportDtoRequest());
    }

    @GetMapping("{fiscalCodeNumber}")
    public List<Report> findPersonHistory (@PathVariable("fiscalCodeNumber") String fiscalCodeNumber){
        return service.getPersonHistory(fiscalCodeNumber);
    }

    @DeleteMapping("{reportTicketNumber}")
    public void deleteReport (@PathVariable("reportTicketNumber") Integer reportTicketNumber) throws BadInputException {
        service.delete(reportTicketNumber);
    }

    @PutMapping("{reportTicketNumber}")
    public ReportDtoResponse update(@PathVariable("reportTicketNumber") Integer reportTicketNumber, @RequestBody ReportResponse response) throws BadInputException {
        return service.update(reportTicketNumber, response.getReportDtoResponse());
    }
}
