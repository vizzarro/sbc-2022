package it.aesys.courses.springboot.controllers;


import it.aesys.courses.springboot.component.CriminalRecordComponent;
import it.aesys.courses.springboot.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("criminalRecord")
public class CriminalRecordController {

    private CriminalRecordComponent component;

    @Autowired
    public CriminalRecordController(CriminalRecordComponent component){
        this.component = component;
    }

    @PostMapping
    public void addReport(String fiscalCodeNumber,@RequestBody Report report) {
        component.addReport(fiscalCodeNumber, report);
    }
    @GetMapping
    public List<Report> getReportList(String fiscalCodeNumber){
        return component.getReportList( fiscalCodeNumber);
    }
}
