package it.aesys.courses.springboot.controllers;

import it.aesys.courses.springboot.model.Report;
import it.aesys.courses.springboot.model.request.PersonRequest;
import it.aesys.courses.springboot.service.impl.CriminalRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("criminalRecord")
public class CriminalRecordController {

    private CriminalRecordServiceImpl service;

    @Autowired
    public CriminalRecordController(CriminalRecordServiceImpl service){
        this.service = service;
    }

    @PostMapping
    public void addReport(@RequestBody PersonRequest request) {
        service.addReport(request.getPerson().getFiscalCodeNumber(), request.getReport());
    }
    @GetMapping
    public List<Report> getReportList(@RequestBody PersonRequest request){
        return service.getCriminalRecord(request.getPerson().getFiscalCodeNumber());
    }

    @PutMapping
    public void updateNewReport(@RequestBody PersonRequest request) {
        service.updateReport(request.getPerson().getFiscalCodeNumber(), request.getReport());
    }

}
