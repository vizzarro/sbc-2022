package it.aesys.courses.springboot.controllers;

import it.aesys.courses.springboot.model.Report;
import it.aesys.courses.springboot.model.request.ReportRequest;
import it.aesys.courses.springboot.service.impl.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("criminalRecord")
public class ReportController {

//    private ReportServiceImpl service;
//
//    @Autowired
//    public ReportController(ReportServiceImpl service){
//        this.service = service;
//    }
//
//    @PostMapping
//    public void addReport(@RequestBody ReportRequest request) {
//        service.addReport(request.getPerson().getFiscalCodeNumber(), request.getReport());
//    }
//    @GetMapping
//    public List<Report> getReportList(@RequestBody ReportRequest request){
//        return service.getCriminalRecord(request.getPerson().getFiscalCodeNumber());
//    }
//
//    @PutMapping
//    public void updateNewReport(@RequestBody ReportRequest request) {
//        service.updateReport(request.getPerson().getFiscalCodeNumber(), request.getReport());
//    }

}
