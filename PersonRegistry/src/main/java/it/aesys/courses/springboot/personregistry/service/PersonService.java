package it.aesys.courses.springboot.personregistry.service;

import it.aesys.courses.springboot.personregistry.dao.impl.PersonDaoImpl;
import it.aesys.courses.springboot.personregistry.models.Person;
import it.aesys.courses.springboot.personregistry.models.PersonDTO;
import it.aesys.courses.springboot.personregistry.models.mapper.Documents;
import it.aesys.courses.springboot.personregistry.models.mapper.PersonMapperDTO;
import it.aesys.courses.springboot.personregistry.repository.PersonDao;
import it.aesys.courses.springboot.personregistry.repository.exception.ComponentException;
import it.aesys.courses.springboot.personregistry.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.websocket.ClientEndpoint;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PersonService {
    private PersonMapperDTO personMapperDTO;
    //private PersonDao personDao;
    private PersonDaoImpl personDao;
    private RestTemplate documentsClient;

    @Autowired
    public PersonService(PersonMapperDTO personMapperDTO, PersonDaoImpl personDao, RestTemplate documentsClient) {
        this.personMapperDTO = personMapperDTO;
        this.personDao = personDao;
        this.documentsClient = documentsClient;
    }

    public PersonDTO create(PersonDTO personDto)  {

//        try {
        return personMapperDTO.toDto(personDao.create(personMapperDTO.toModel(personDto)));
//        } catch (ServiceException e) {
//            ServiceException ex = new ServiceException();
//           ex.setStatusCode(e.getStatusCode());
//            ex.setMessage("Impossible to create");
//            throw ex;
//        }
    }

//    public PersonDTO get(String fiscalcode)  {

//        try {
//        return personMapperDTO.toDto(personDao.get(fiscalcode));

//        } catch (ComponentException e) {
//            ServiceException ex = new ServiceException();
//            ex.setStatusCode(e.getStatusCode());
//            ex.setMessage("Resource not found");
//            throw ex;
//        }
//    }

    public Collection<PersonDTO> getAll() throws ComponentException {


        Collection<PersonDTO> allPersonsDto = new ArrayList<>();

        Collection<Person> allPersons = personDao.getAll();

        allPersons.forEach(x -> allPersonsDto.add(personMapperDTO.toDto(x)));

        return allPersonsDto;

    }

    public PersonDTO update( PersonDTO personDTO) //throws ComponentException, ServiceException
    {

        //       try {
<<<<<<< HEAD
        if (personMapperDTO.toDto(personDao.get(fiscalcode)).equals("SELECT fiscalcode FROM person WHERE fiscalcode =  ?")) {
            Person updatedPerson = personMapperDTO.toModel(personDTO);
            personDao.update(updatedPerson);
            return personMapperDTO.toDto(updatedPerson);
            } else {
                ServiceException exc = new ServiceException();
                exc.setStatusCode(404);
                exc.setMessage("Resource not found");
=======
        if (personMapperDTO.toDto(personDao.get(personDTO.getFiscalCode())) != null) {
        Person updatedPerson = personMapperDTO.toModel(personDTO);
        personDao.update(updatedPerson);
        return personMapperDTO.toDto(updatedPerson);
//            } else {
//                ServiceException exc = new ServiceException();
//                exc.setStatusCode(404);
//                exc.setMessage("Resource not found");
>>>>>>> 35b2ede3f0b5739f42551decdfb229dd64aa8e05
//                throw exc;
            }
//        } catch (SQLException e) {
//            ServiceException ex = new ServiceException();
//            ex.setStatusCode(e.getErrorCode());
//            ex.setMessage("Resource not found");
//            throw ex;
//        }
        return personDTO;
    }


    public void delete(String fiscalcode) //throws ComponentException, ServiceException
    {

        if (personMapperDTO.toDto(personDao.get(fiscalcode)).equals("SELECT fiscalcode FROM person WHERE fiscalcode =  ?")) {
            personDao.get(fiscalcode);
            personDao.delete(fiscalcode);
        } else {
            ServiceException exc = new ServiceException();
            exc.setStatusCode(404);
            exc.setMessage("Resource not found");
//            throw exc;
        }

    }


//    public PersonDTO getPersonFC(String fiscalCode) throws ServiceException {

//        try {
//
//            PersonDTO person = personMapperDTO.toDto(personDao.get(fiscalCode));
//            //TODO: ARRICHIRE DATI del person con dati del documento
//
//            ResponseEntity<Documents> documentResponse = documentsClient.getForEntity("http://localhost:8081/document?cf=" + fiscalCode
//                    , Documents.class);
//
//            person.setDocuments(documentResponse.getBody());
//
//            if (documentResponse.getStatusCode().equals(HttpStatus.OK)) {
//
//                return person;
//            }
//        } catch (ComponentException e) {
//            throw new RuntimeException(e);
//        }
//        return null;
//    }
}




