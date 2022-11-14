package it.aesys.courses.springboot.component;

import it.aesys.courses.springboot.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CriminalRecordComponent {

    private Map<String, List<Report>> criminalMap;

    private Report report;
    @Autowired
    public CriminalRecordComponent(){
        this.criminalMap= new HashMap<>();
        this.criminalMap.put("prova1",null);
    }

    public void addReport(String fiscalCodeNumber, Report report){
        this.criminalMap.get(fiscalCodeNumber).add(report);
    }

    public void addNewPerson(String fiscalCodeNumber){
        this.criminalMap.put(fiscalCodeNumber,null);
    }

    public List<Report> getReportList(String fiscalCodeNumber){
        return this.criminalMap.get(fiscalCodeNumber);
    }

}

