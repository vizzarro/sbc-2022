package it.aesys.courses.springboot.personregistry.controller;

import it.aesys.courses.springboot.personregistry.models.Person;
import it.aesys.courses.springboot.personregistry.models.PersonDTO;
import it.aesys.courses.springboot.personregistry.repository.exception.ComponentException;
import it.aesys.courses.springboot.personregistry.request.PersonRequest;
import it.aesys.courses.springboot.personregistry.service.PersonService;
import it.aesys.courses.springboot.personregistry.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Collection;

@RestController
@RequestMapping("personregistry")
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


    @DeleteMapping("/{fiscalcode}")
    public void deletePerson(@PathVariable("fiscalcode") String fiscalcode ) throws ServiceException, ComponentException{
         service.delete(fiscalcode);
    }

    @GetMapping("all")
    public Collection<PersonDTO> getAllPersons() throws ServiceException, ComponentException {
        return service.getAll();
    }

//    @GetMapping("/{id}")
//    public PersonDTO getById(@PathVariable("id") Integer id) throws ServiceException, ComponentException {
//        return service.get(id);
//    }

    @GetMapping("{fiscalCode}")
    public PersonDTO getPersonByFiscalCode(@PathVariable("fiscalCode") String fiscalCode) throws ServiceException, ComponentException {
        return service.getPersonFC(fiscalCode);
    }

    @PutMapping("{fiscalcode}")
    public  PersonDTO update(@PathVariable("fiscalcode") String fiscalcode, @RequestBody PersonRequest request) throws ServiceException, ComponentException{
        return service.update(fiscalcode, request.getPersonDTO());
    }
}
