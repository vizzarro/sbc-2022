package it.aesys.courses.springboot.service;

import it.aesys.courses.springboot.dao.ReportDao;
import it.aesys.courses.springboot.model.mapperDTO.ReportMapperDTO;

public interface EvaluateService {
    public boolean evaluate(String fiscalCodeNumber);
}
