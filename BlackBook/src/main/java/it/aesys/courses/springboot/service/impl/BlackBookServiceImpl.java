package it.aesys.courses.springboot.service.impl;

import it.aesys.courses.springboot.model.CriminalRecord;
import it.aesys.courses.springboot.service.BlackBookService;
import org.springframework.stereotype.Service;

@Service
public class BlackBookServiceImpl implements BlackBookService {

    @Override
    public CriminalRecord getCriminalRecord(String fiscalCodeNumber) {
        return null;
    }

    @Override
    public CriminalRecord addCriminalRecord (CriminalRecord newCriminalRecord) {
        return null;
    }

    @Override
    public CriminalRecord updateCriminalRecord(String fiscalCodeNumber, CriminalRecord updated) {
        return null;
    }
}
