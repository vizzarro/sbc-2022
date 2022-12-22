package it.aesys.courses.springboot.personregistry.service;

import it.aesys.courses.springboot.personregistry.models.PersonDTO;
import it.aesys.courses.springboot.personregistry.service.exceptions.ServiceException;

import java.util.Collection;

public interface PersonService {
    public PersonDTO create(PersonDTO personDto);
    public PersonDTO get(String fiscalcode) throws ServiceException;
    public Collection<PersonDTO> getAll();
    public PersonDTO update(String fiscalcode, PersonDTO personDTO) throws ServiceException;
    public void delete (String fiscalcode) throws ServiceException;
}
