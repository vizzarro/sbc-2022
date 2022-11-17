package it.aesys.courses.springboot.personregistry.service;

import it.aesys.courses.springboot.personregistry.dao.PersonDao;
import it.aesys.courses.springboot.personregistry.dao.exception.DaoException;
import it.aesys.courses.springboot.personregistry.dao.impl.AddressDaoImpl;
import it.aesys.courses.springboot.personregistry.dao.impl.PersonDaoImpl;
import it.aesys.courses.springboot.personregistry.models.AddressDTO;
import it.aesys.courses.springboot.personregistry.models.Person;
import it.aesys.courses.springboot.personregistry.models.PersonDTO;
import it.aesys.courses.springboot.personregistry.models.mapper.PersonMapperDTO;

import it.aesys.courses.springboot.personregistry.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class PersonServiceImpl implements PersonService {
    private PersonMapperDTO personMapperDTO;
    //private PersonDao personDao;
    private PersonDaoImpl personDao;
    private RestTemplate documentsClient;

    private AddressDaoImpl addressDao;

    @Autowired
    public PersonServiceImpl(PersonMapperDTO personMapperDTO, PersonDaoImpl personDao, RestTemplate documentsClient, AddressDaoImpl addressDao) {
        this.personMapperDTO = personMapperDTO;
        this.personDao = personDao;
        this.documentsClient = documentsClient;
        this.addressDao = addressDao;
    }

    public PersonDTO create(PersonDTO personDto) throws ServiceException {

        try {

            personMapperDTO.toDto(personDao.create(personMapperDTO.toModel(personDto)));
        } catch (DaoException e) {
            ServiceException ex = new ServiceException();
//            ex.setStatusCode(e.getStatusCode());
            ex.setMessage("Impossible to create");
            throw ex;
        }
        return personDto;
    }

    public PersonDTO get(String fiscalcode) throws ServiceException {

        try {
            return personMapperDTO.toDto(personDao.get(fiscalcode));

        } catch (DaoException e) {
            ServiceException ex = new ServiceException();
//            ex.setStatusCode(e.getStatusCode());
            ex.setMessage("Resource not found");
            throw ex;
        }
    }

    public Collection<PersonDTO> getAll() throws ServiceException {


        Collection<PersonDTO> allPersonsDto = new ArrayList<>();

        Collection<Person> allPersons = null;
        try {
            allPersons = personDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        allPersons.forEach(x -> allPersonsDto.add(personMapperDTO.toDto(x)));

        return allPersonsDto;

    }

    public PersonDTO update(String fiscalcode, PersonDTO personDTO) throws ServiceException {

        try {

            if (personMapperDTO.toDto(personDao.get(fiscalcode)) != null) {
                Person updatedPerson = personMapperDTO.toModel(personDTO);
                personDao.update(updatedPerson);
                return personMapperDTO.toDto(updatedPerson);
            } else {
                if (personMapperDTO.toDto(personDao.get(personDTO.getFiscalCode())) != null) {
                    Person updatedPerson = personMapperDTO.toModel(personDTO);
                    personDao.update(updatedPerson);
                    return personMapperDTO.toDto(updatedPerson);
                } else {
                    ServiceException serviceException = new ServiceException();
                    serviceException.setStatusCode(404);
                    serviceException.setMessage("Resource not found");

                    throw serviceException;
                }
            }
        } catch (DaoException e) {
            ServiceException se = new ServiceException();
//            se.setStatusCode(e.getErrorCode())
            throw se;
        }
    }


    public void delete(String fiscalcode) throws ServiceException {
        try {
            if (personMapperDTO.toDto(personDao.get(fiscalcode)) != null) {
                personDao.get(fiscalcode);
                personDao.delete(fiscalcode);
            } else {
                ServiceException exc = new ServiceException();
                exc.setStatusCode(404);
                exc.setMessage("Resource not found");
                throw exc;
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        } catch (ServiceException e) {
            throw e;
        }

    }

}




