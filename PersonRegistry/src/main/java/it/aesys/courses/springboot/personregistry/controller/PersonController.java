package it.aesys.courses.springboot.personregistry.controller;

import it.aesys.courses.springboot.personregistry.models.PersonDTO;
import it.aesys.courses.springboot.personregistry.service.PersonService;
import it.aesys.courses.springboot.personregistry.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("personregistry")
//@Profile("")
public class PersonController {



    private PersonService service;

    @Autowired
    public PersonController(PersonService service){
        this.service = service;
    }

    @PostMapping
    public PersonDTO addPerson(@RequestBody request.PersonRequest personRequest) throws ServiceException {

        return service.create(personRequest.getPersonDTO());
    }



}
