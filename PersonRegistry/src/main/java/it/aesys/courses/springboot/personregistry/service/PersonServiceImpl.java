package it.aesys.courses.springboot.personregistry.service; //SERVICE CLASS
import it.aesys.courses.springboot.personregistry.models.Person;
import it.aesys.courses.springboot.personregistry.models.PersonDTO;
import it.aesys.courses.springboot.personregistry.models.Address;
import it.aesys.courses.springboot.personregistry.dao.exception.DaoException;
import it.aesys.courses.springboot.personregistry.models.mapper.PersonMapperDTO;
import it.aesys.courses.springboot.personregistry.models.mapper.DocumentDTO;
import it.aesys.courses.springboot.personregistry.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import it.aesys.courses.springboot.personregistry.repository.PersonRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.transaction.annotation.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Collection;
    @Service
    @Transactional(readOnly = true)
    public class PersonServiceImpl implements PersonService {
    private final PersonMapperDTO personMapperDTO;

    private final PersonRepository personRepository;
    //private final PersonDao personDao;

    //private final AddressDao addressDao;
    private final RestTemplate restTemplate;

    @Autowired
    public PersonServiceImpl(PersonMapperDTO personMapperDTO,PersonRepository personRepository , RestTemplate restTemplate) {
        this.personMapperDTO = personMapperDTO;
        this.personRepository = personRepository;
        this.restTemplate = restTemplate;
     }

    @Transactional
    public PersonDTO create(PersonDTO personDto) {

        Person person = personMapperDTO.toModel(personDto);
        person = personRepository.save(person);
        PersonDTO personDTOtoReturn;
        personDTOtoReturn = personMapperDTO.toDto(person);
        personDTOtoReturn.setDocuments(this.getDocumentsByCf(personDTOtoReturn.getFiscalCode()));
        return personDTOtoReturn;

    }

    private Person checkAndReturnPersonIfExistsByFiscalCode(String fiscalcode) throws ServiceException {
        if (fiscalcode != null) {
            Optional<Person> person = personRepository.findById(fiscalcode);
            if (person.isEmpty()) {
                ServiceException serviceException = new ServiceException();
                serviceException.setStatusCode(HttpStatus.NOT_FOUND.value());
                serviceException.setMessage("Person with fiscalcode " + fiscalcode + " not found");
                throw serviceException;
            }

            return person.get();
        } else {
            ServiceException serviceException = new ServiceException();
            serviceException.setStatusCode(HttpStatus.BAD_REQUEST.value());
            serviceException.setMessage("Invalid Input , fiscalCode is Null!");
            throw serviceException;
        }
    }
    public PersonDTO get(String fiscalcode) throws ServiceException {
        PersonDTO personDto = personMapperDTO.toDto(checkAndReturnPersonIfExistsByFiscalCode(fiscalcode));
        personDto.setDocuments(this.getDocumentsByCf(personDto.getFiscalCode()));
        return personDto;
    }
    public Collection<PersonDTO> getAll() {
        Collection<PersonDTO>  allPersonsDto = new ArrayList<>();
        Collection<Person>  allPersons = personRepository.findAll();

        for (Person p : allPersons){
            PersonDTO personDTO = personMapperDTO.toDto(p);
            personDTO.setDocuments(this.getDocumentsByCf(p.getFiscalCode()));
            allPersonsDto.add(personDTO);
        }
/*       allPersons.forEach( p -> {
            PersonDTO personDTO = personMapperDTO.toDto(p);
            personDTO.setDocuments(this.getDocumentsByCf(p.getFiscalCode()));
            allPersonsDto.add(personMapperDTO.toDto(p));
        });
        */
        return allPersonsDto;
    }
    @Transactional
    public PersonDTO update(String fiscalCode, PersonDTO personDTO) throws ServiceException {
        Person oldPerson = this.checkAndReturnPersonIfExistsByFiscalCode(fiscalCode);
        Person updatedPerson = personMapperDTO.toModel(personDTO);
        updatedPerson.setFiscalCode(oldPerson.getFiscalCode());
        updatedPerson.getAddress().setAddressId(oldPerson.getAddress().getAddressId());
        updatedPerson = personRepository.save(updatedPerson);

        PersonDTO personDto = personMapperDTO.toDto(updatedPerson);
        personDto.setDocuments(this.getDocumentsByCf(personDto.getFiscalCode()));
        return personDto;
    }

    @Transactional
    public void delete(String fiscalcode) throws ServiceException {
    Person person = checkAndReturnPersonIfExistsByFiscalCode(fiscalcode);
     personRepository.delete(person);
    }
    private List<DocumentDTO> getDocumentsByCf(String fiscalCode) {
        String url = "http://localhost:8081/document?cf=" + fiscalCode ;
        ResponseEntity<List<DocumentDTO>> response   = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<DocumentDTO>>(){});
        if (response.getStatusCode().equals(HttpStatus.OK)){
            return response.getBody();
        }
        else {
            System.out.println("Unable to get documents by cf: " + fiscalCode + ", statusCode: " + response.getStatusCode().value());
            return null;
        }
    }
}
