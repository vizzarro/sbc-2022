package it.aesys.courses.springboot.controllers;

import it.aesys.courses.springboot.model.mapperDTO.ReportDTO;
import it.aesys.courses.springboot.model.request.ReportRequest;
import it.aesys.courses.springboot.service.impl.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("report")
public class ReportController {

    private ReportServiceImpl service;

    @Autowired
    public ReportController(ReportServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ReportDTO create(@RequestBody ReportRequest request) {
        return service.create(request.getReportDTO());
    }

    @GetMapping("{fiscalCodeNumber}")
    public ReportDTO findPersonHistory (@PathVariable("fiscalCodeNumber") String fiscalCodeNumber){
        return service.getPersonHistory(fiscalCodeNumber);
    }

    @GetMapping("{reportTicketNumber}")
    public ReportDTO findReportTicket(@PathVariable("reportTicketNumber") String reportTicketNumber){
        return service.getReportTicket(reportTicketNumber);
    }

    @DeleteMapping("{reportTicketNumber}")
    public void deleteReport (@PathVariable("reportTicketNumber") String reportTicketNumber) {
        service.delete(reportTicketNumber);
    }

    @PutMapping("{reportTicketNumber}")
    public ReportDTO update(@PathVariable("fiscalCodeNumber") String fiscalCodeNumber, @RequestBody ReportRequest request) {
        return service.update(request.getReportDTO());
    }

}
