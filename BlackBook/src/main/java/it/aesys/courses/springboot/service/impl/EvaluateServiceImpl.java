package it.aesys.courses.springboot.service.impl;

import it.aesys.courses.springboot.component.CriminalRecordComponent;
import it.aesys.courses.springboot.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvaluateServiceImpl implements EvaluateService {

    @Autowired
    private CriminalRecordComponent criminalRecordComponent;

    @Override
    public boolean evaluatePerson(String fiscalCodeNumber) {

        if(this.criminalRecordComponent.getReportList(fiscalCodeNumber).size()<3){
            return true;
        }
        return false;
    }
}
