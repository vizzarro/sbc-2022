package it.aesys.courses.springboot.controllers;

import it.aesys.courses.springboot.model.mapperDTO.PersonDTO;
import it.aesys.courses.springboot.model.request.PersonRequest;
import it.aesys.courses.springboot.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("person")
public class PersonController {

    private PersonServiceImpl service;

    @Autowired
    public PersonController (PersonServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public PersonDTO create(@RequestBody PersonRequest request) {
        return service.create(request.getPersonDto());
    }

    @GetMapping("{fiscalCodeNumber}")
    public PersonDTO findPerson(@PathVariable("fiscalCodeNumber") String fiscalCodeNumber){
        return service.get(fiscalCodeNumber);
    }

    @DeleteMapping("{fiscalCodeNumber}")
    public void delete (@PathVariable("fiscalCodeNumber") String fiscalCodeNumber) {
        service.delete(fiscalCodeNumber);
    }

    @PutMapping("{fiscalCodeNumber}")
    public PersonDTO update(@PathVariable("fiscalCodeNumber") String fiscalCodeNumber, @RequestBody PersonRequest request) {
        return service.update(request.getPersonDto());
    }

}
