package it.aesys.courses.springboot.service;

import it.aesys.courses.springboot.component.CriminalRecordComponent;

public interface CriminalRecordService {

    CriminalRecordComponent getCriminalRecord (String fiscalCodeNumber);
    CriminalRecordComponent addCriminalRecord(CriminalRecordComponent newCriminalRecord);
    CriminalRecordComponent updateCriminalRecord(String fiscalCodeNumber, CriminalRecordComponent updated);
}
