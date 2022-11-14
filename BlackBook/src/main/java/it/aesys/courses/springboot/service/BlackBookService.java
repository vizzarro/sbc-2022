package it.aesys.courses.springboot.service;

import it.aesys.courses.springboot.model.CriminalRecord;

public interface BlackBookService {

    CriminalRecord getCriminalRecord (String fiscalCodeNumber);
    CriminalRecord addCriminalRecord(CriminalRecord newCriminalRecord);
    CriminalRecord updateCriminalRecord(String fiscalCodeNumber, CriminalRecord updated);
}
