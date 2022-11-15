package it.aesys.courses.springboot.personregistry.service;

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
import java.util.ArrayList;
import java.util.Collection;

@Service
public class PersonService {

    private PersonMapperDTO personMapperDTO;
    private PersonDao personDao;

    private RestTemplate documentsClient;

    @Autowired
    public PersonService(PersonMapperDTO personMapperDTO, PersonDao personDao, RestTemplate documentsClient) {
        this.personMapperDTO = personMapperDTO;
        this.personDao = personDao;
        this.documentsClient = documentsClient;
    }

    public PersonDTO create(PersonDTO personDto) throws ServiceException {

        try {
            return personMapperDTO.toDto(personDao.createPerson(personMapperDTO.toModel(personDto)));
        } catch (ComponentException e) {
            ServiceException ex = new ServiceException();
            ex.setStatusCode(e.getStatusCode());
            throw ex;
        }
    }

    public PersonDTO get(Integer id) throws ServiceException {

        try {
            return personMapperDTO.toDto(personDao.getPerson(id));

        } catch (ComponentException e) {
            ServiceException ex = new ServiceException();
            ex.setStatusCode(e.getStatusCode());
            throw ex;
        }
    }

    public Collection<PersonDTO> getAll() throws ComponentException {


        Collection<PersonDTO> allHeroCharactersDto = new ArrayList<>();

        Collection<Person> allHeroCharacters = personDao.getAllPersons();

        allHeroCharacters.forEach(x -> allHeroCharactersDto.add(personMapperDTO.toDto(x)));

        return allHeroCharactersDto;

    }


    public PersonDTO update(Integer id, PersonDTO personDTO) throws ComponentException, ServiceException {

        try {
            if (personMapperDTO.toDto(personDao.getPerson(id)) != null) {
                Person updatedPerson = personMapperDTO.toModel(personDTO);
                personDao.updatePerson(id, updatedPerson);
                return personMapperDTO.toDto(updatedPerson);
            } else {
                ServiceException exc = new ServiceException();
                exc.setStatusCode(404);
                throw exc;
            }
        } catch (ComponentException e) {
            ServiceException ex = new ServiceException();
            ex.setStatusCode(e.getStatusCode());
            throw ex;
        }
    }


    public void delete(Integer id) throws ComponentException, ServiceException {

        if (personMapperDTO.toDto(personDao.getPerson(id)) != null) {
            personDao.getPerson(id);
            personDao.deletePerson(id);
        } else {
            ServiceException exc = new ServiceException();
            exc.setStatusCode(404);
            throw exc;
        }

    }


    public PersonDTO getPersonFC(String fiscalCode) throws ServiceException {

        try {

            PersonDTO person = personMapperDTO.toDto(personDao.getPersonByFiscalCode(fiscalCode));
            //ARRICHIRE DATI del person con dati del documento
            ResponseEntity<Documents> documentResponse = documentsClient.getForEntity("", Documents.class);
            if (documentResponse.getStatusCode().equals(HttpStatus.OK)) {

                return personMapperDTO.toDto(personDao.getPersonByFiscalCode(fiscalCode));
            }
        } catch (ComponentException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}




