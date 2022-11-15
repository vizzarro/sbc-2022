package it.aesys.courses.springboot.controllers;

import it.aesys.courses.springboot.model.request.PersonRequest;
import it.aesys.courses.springboot.service.impl.EvaluateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("evaluate")
public class EvaluateController {

    private EvaluateServiceImpl service;
    @Autowired
    public EvaluateController(EvaluateServiceImpl service) {
        this.service = service;
    }
    @GetMapping
    public boolean evaluatePerson(@RequestBody PersonRequest request){
        return service.evaluatePerson(request.getPerson().getFiscalCodeNumber());
    }
}
