package it.aesys.courses.springboot.service.impl;

import it.aesys.courses.springboot.component.CriminalRecordComponent;
import it.aesys.courses.springboot.service.CriminalRecordService;
import org.springframework.stereotype.Service;

@Service
public class CriminalRecordServiceImpl implements CriminalRecordService {

    @Override
    public CriminalRecordComponent getCriminalRecord(String fiscalCodeNumber) {
        return null;
    }

    @Override
    public CriminalRecordComponent addCriminalRecord (CriminalRecordComponent newCriminalRecord) {
        return null;
    }

    @Override
    public CriminalRecordComponent updateCriminalRecord(String fiscalCodeNumber, CriminalRecordComponent updated) {
        return null;
    }
}
