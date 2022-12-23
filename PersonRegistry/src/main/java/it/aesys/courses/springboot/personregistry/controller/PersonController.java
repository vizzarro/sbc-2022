package it.aesys.courses.springboot.personregistry.controller;
import it.aesys.courses.springboot.personregistry.CustomValidators.FiscalCodeValidator;
import it.aesys.courses.springboot.personregistry.dao.exception.DaoException;
import it.aesys.courses.springboot.personregistry.models.PersonDTO;
import it.aesys.courses.springboot.personregistry.service.PersonService;
import it.aesys.courses.springboot.personregistry.request.PersonRequest;
import it.aesys.courses.springboot.personregistry.service.exceptions.ServiceException;
import it.aesys.courses.springboot.personregistry.service.PersonServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import java.util.Collection;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("personregistry")
public class PersonController  {
    private PersonService service;

    @Autowired
    public PersonController(PersonServiceImpl service ){
        this.service = service;
    }
    @PostMapping
    public PersonDTO addPerson(@Validated(FiscalCodeValidator.class)@RequestBody PersonRequest personRequest){
        return service.create(personRequest.getPersonDTO());
    }
    @DeleteMapping("{fiscalCode}" )
    public void deletePerson(@Validated(FiscalCodeValidator.class) @PathVariable("fiscalCode" ) String fiscalCode ) throws ServiceException{
         service.delete(fiscalCode);
    }

    @GetMapping("all")
    public Collection<PersonDTO> getAllPersons() {
        return service.getAll();
    }

    @GetMapping("{fiscalCode}")
    public PersonDTO getPersonByFiscalCode(@Validated(FiscalCodeValidator.class) @PathVariable("fiscalCode") String fiscalCode ) throws ServiceException {
        return service.get( fiscalCode );}

    @PutMapping("{fiscalCode}")
    public  PersonDTO update(@Validated(FiscalCodeValidator.class) @PathVariable("fiscalCode") String fiscalCode, @RequestBody PersonRequest request) throws ServiceException {
        return service.update(fiscalCode, request.getPersonDTO());}
    }