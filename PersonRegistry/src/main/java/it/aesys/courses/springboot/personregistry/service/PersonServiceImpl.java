package it.aesys.courses.springboot.personregistry.service;

import it.aesys.courses.springboot.personregistry.dao.AddressDao;
import it.aesys.courses.springboot.personregistry.dao.PersonDao;
import it.aesys.courses.springboot.personregistry.dao.exception.DaoException;
import it.aesys.courses.springboot.personregistry.dao.impl.AddressDaoImpl;
import it.aesys.courses.springboot.personregistry.dao.impl.PersonDaoImpl;
import it.aesys.courses.springboot.personregistry.models.Address;
import it.aesys.courses.springboot.personregistry.models.Person;
import it.aesys.courses.springboot.personregistry.models.PersonDTO;
import it.aesys.courses.springboot.personregistry.models.mapper.AddressMapperDTO;
import it.aesys.courses.springboot.personregistry.models.mapper.PersonMapperDTO;

import it.aesys.courses.springboot.personregistry.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchDataSourceScriptDatabaseInitializer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonMapperDTO personMapperDTO;
    private final PersonDao personDao;

    private final AddressDao addressDao;
    private final RestTemplate documentsClient;



    @Autowired
    public PersonServiceImpl(PersonMapperDTO personMapperDTO, PersonDaoImpl personDao, AddressDaoImpl addressDao, RestTemplate documentsClient) {
        this.personMapperDTO = personMapperDTO;
        this.personDao = personDao;
        this.addressDao = addressDao;
        this.documentsClient = documentsClient;
    }

    public PersonDTO create(PersonDTO personDto) throws ServiceException {

        try {

            //Address address = addressDao.create(personMapperDTO.toModel(personDto).getAddress());
            Integer addressId = addressDao.createAddress(personMapperDTO.toModel(personDto).getAddress());
            Person person = personMapperDTO.toModel(personDto);
            //person.setAddressId(address.addressId);
            person.setAddressId(addressId);
            personDao.create(person);
            return personDto;

        } catch (DaoException e) {
            ServiceException ex = new ServiceException();
//            ex.setStatusCode(e.getStatusCode());
            ex.setMessage("Impossible to create");
            throw ex;
        }
    }

    public PersonDTO get(String fiscalcode) throws ServiceException {

        try {
            if (fiscalcode != null) {

                Person person = personDao.get(fiscalcode);
                person.setAddress(addressDao.getAddress(person.getAddressId()));
                return personMapperDTO.toDto(person);
            }
        } catch (DaoException e) {
            ServiceException ex = new ServiceException();
//            ex.setStatusCode(e.getStatusCode());
            ex.setMessage("Resource not found");
            throw ex;
        }
        //TODO implementare eccezzione
        return null;
    }

    public Collection<PersonDTO> getAll() throws ServiceException {


        Collection<PersonDTO> allPersonsDto = new ArrayList<>();

        Collection<Person> allPersons = null;

        Collection<Address> allAddress = null;

        Collection<Person> allPersonsWithAddress = new ArrayList<>();
        try {
            allPersons = personDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        try {
            allAddress = addressDao.getAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        for (Person person : allPersons){
            for (Address address : allAddress){
                if (address.getAddressId() == person.getAddressId()){
                    person.setAddress(address);
                    allPersonsWithAddress.add(person);
                }
            }
        }

//        BiConsumer<Collection<Person>, Collection<Address>> mergeBiConsumer;
//
//        allPersons.forEach( mergeBiConsumer(p , a) -> p.setAddress() );

        allPersonsWithAddress.forEach(x -> allPersonsDto.add(personMapperDTO.toDto(x)));

        return allPersonsDto;

    }

    public PersonDTO update(String fiscalcode, PersonDTO personDTO) throws ServiceException {

        try {

            if ( personDao.get(fiscalcode) != null) {
                Person updatedPerson = personMapperDTO.toModel(personDTO);
                Address address = addressDao.create(updatedPerson.getAddress());
                updatedPerson.setAddressId(address.getAddressId());
                personDao.update(updatedPerson);
                return personMapperDTO.toDto(updatedPerson);
                }
            else {
                    ServiceException serviceException = new ServiceException();
                    serviceException.setStatusCode(404);
                    serviceException.setMessage("Resource not found");

                    throw serviceException;
                }

        } catch (DaoException e) {
            ServiceException se = new ServiceException();
//            se.setStatusCode(e.getErrorCode())
            throw se;
        }
    }


    public void delete(String fiscalcode) throws ServiceException {
        try {
            if (personDao.get(fiscalcode) != null) {
                Person personToDelete = personDao.get(fiscalcode);
                addressDao.deleteAddress(personToDelete.getAddressId());
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




