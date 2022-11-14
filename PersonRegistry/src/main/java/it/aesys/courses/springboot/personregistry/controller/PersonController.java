package it.aesys.courses.springboot.personregistry.controller;

import it.aesys.courses.springboot.personregistry.models.PersonDTO;
import it.aesys.courses.springboot.personregistry.repository.exception.ComponentException;
import it.aesys.courses.springboot.personregistry.request.PersonRequest;
import it.aesys.courses.springboot.personregistry.service.PersonService;
import it.aesys.courses.springboot.personregistry.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

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
    public PersonDTO addPerson(@RequestBody PersonRequest personRequest) throws ServiceException, ComponentException {
        return service.create(personRequest.getPersonDTO());
    }

    @GetMapping("/{id}")
    public PersonDTO getPersonById(@PathVariable("id") Integer id) throws ServiceException, ComponentException {
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") Integer id ) throws ServiceException, ComponentException{
        return service.delete(id);
    }




}
