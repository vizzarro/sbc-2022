package it.aesys.courses.springboot.service.impl;

import it.aesys.courses.springboot.dao.ReportDao;
import it.aesys.courses.springboot.model.mapperDTO.ReportMapperDTO;
import it.aesys.courses.springboot.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;

public class EvaluateServiceImpl implements EvaluateService {
    private ReportDao reportDao;

    @Autowired
    public EvaluateServiceImpl(ReportDao reportDao, ReportMapperDTO mapper) {
        this.reportDao = reportDao;
    }

    @Override
    public boolean evaluate(String fiscalCodeNumber) {
        if (reportDao.getReport(fiscalCodeNumber).size() < 3) {
            return true;
        } else {
            return false;
        }
    }
}
