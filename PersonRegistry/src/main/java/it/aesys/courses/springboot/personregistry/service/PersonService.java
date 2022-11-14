package it.aesys.courses.springboot.personregistry.service;

import it.aesys.courses.springboot.personregistry.repository.PersonDao;
import it.aesys.courses.springboot.personregistry.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonService {

    private PersonMapperDTO personMapperDTO;
    private PersonDao personDao;


    @Autowired
    public PersonService(PersonMapperDTO personMapperDTO, PersonDao personDao){
        this.personMapperDTO = personMapperDTO;
        this.personDao = personDao;
    }

    public PersonMapperDTO create(PersonMapperDTO personMapperDTO) throws ServiceException {

        try {
            return personMapperDTO.toDto(personDao.create(personMapperDTO.toModel(personDto)));
        }
        catch (ComponentException e){
            ServiceException ex = new ServiceException();
            ex.setStatusCode(e.getStatusCode());
            throw ex;
        }
    }

}
