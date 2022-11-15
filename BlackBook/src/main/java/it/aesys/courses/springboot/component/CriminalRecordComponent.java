package it.aesys.courses.springboot.component;

import it.aesys.courses.springboot.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
    }

    public void addReport(String fiscalCodeNumber, Report report){
       initPerson(fiscalCodeNumber);
       this.criminalMap.get(fiscalCodeNumber).add(report);
    }

    private void initPerson(String fiscalCodeNumber) {
        if (!this.criminalMap.containsKey(fiscalCodeNumber)) {
           List<Report> reportList = new ArrayList<>();
           this.criminalMap.put(fiscalCodeNumber, reportList);
        }
    }

    public List<Report> getReportList(String fiscalCodeNumber){
        return this.criminalMap.get(fiscalCodeNumber);
    }

    public void addNewReport(String fiscalCodeNumber, Report report){
        if (this.criminalMap.containsKey(fiscalCodeNumber))
            this.criminalMap.get(fiscalCodeNumber).add(report);
    }
}

