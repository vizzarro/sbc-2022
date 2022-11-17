package it.aesys.courses.springboot.controllers;

import it.aesys.courses.springboot.service.impl.EvaluateServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("canborrow")
public class EvaluateController {

    private EvaluateServiceImpl service;

    @Autowired
    public EvaluateController(EvaluateServiceImpl service) {
        this.service = service;
    }

    @GetMapping("{fiscalCodeNumber}")
    public boolean evaluate(@PathVariable("fiscalCodeNumber") String fiscalCodeNumber) {
        return service.evaluate(fiscalCodeNumber);
    }
}
