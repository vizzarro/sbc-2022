package it.aesys.courses.springboot.controllers;

import it.aesys.courses.springboot.component.CriminalRecordComponent;
import it.aesys.courses.springboot.model.Report;
import it.aesys.courses.springboot.model.request.PersonRequest;
import it.aesys.courses.springboot.service.impl.CriminalRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
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
        service.addReport(request.getFiscalCode(), request.getReport());
    }
    @GetMapping("{fiscalCodeNumber}")
    public List<Report> getReportList(@PathVariable("fiscalCodeNumber") String fiscalCodeNumber){
        return service.getCriminalRecord(fiscalCodeNumber);
    }

}
