package it.aesys.courses.springboot.personregistry.service;

import it.aesys.courses.springboot.personregistry.models.Person;
import it.aesys.courses.springboot.personregistry.models.PersonDTO;
import it.aesys.courses.springboot.personregistry.models.mapper.PersonMapperDTO;
import it.aesys.courses.springboot.personregistry.repository.PersonDao;
import it.aesys.courses.springboot.personregistry.repository.exception.ComponentException;
import it.aesys.courses.springboot.personregistry.service.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;

public class PersonService {

    private PersonMapperDTO personMapperDTO;
    private PersonDao personDao;


    @Autowired
    public PersonService(PersonMapperDTO personMapperDTO, PersonDao personDao){
        this.personMapperDTO = personMapperDTO;
        this.personDao = personDao;
    }

    public PersonDTO create(PersonDTO personDto) throws ServiceException {

        try {
            return personMapperDTO.toDto(personDao.createPerson(personMapperDTO.toModel(personDto)));
        }
        catch (ComponentException e){
            ServiceException ex = new ServiceException();
            ex.setStatusCode(e.getStatusCode());
            throw ex;
        }
    }
    public PersonDTO get(Integer id) throws ComponentException, ServiceException {

        try {
            return personMapperDTO.toDto(personDao.getPerson(id)) ;

        }
        catch (ComponentException e){
            ServiceException ex = new ServiceException();
            ex.setStatusCode(e.getStatusCode());
            throw ex;
        }
    }

    public Collection<PersonDTO> getAll() throws ComponentException, ServiceException {


        Collection< PersonDTO> allHeroCharactersDto = new ArrayList<>();

        Collection<Person> allHeroCharacters = personDao.getAllPersons();

        allHeroCharacters.forEach(x -> allHeroCharactersDto.add(personMapperDTO.toDto(x)) );

        return allHeroCharactersDto;

    }



    public PersonDTO update(Integer id, PersonDTO personDTO) throws ComponentException, ServiceException {

        try {
            if (personDao.getPerson(personMapperDTO.toModel(personDTO).getId()) !=null) {
                Person updatedPerson = personMapperDTO.toModel(personDTO);
                personDao.updatePerson(id, updatedPerson);
                return personMapperDTO.toDto(updatedPerson);
            }
            else {
                ServiceException exc = new ServiceException();
                exc.setStatusCode(404);
                throw exc;
            }
        }
        catch (ComponentException e){
            ServiceException ex = new ServiceException();
            ex.setStatusCode(e.getStatusCode());
            throw ex;
        }
    }

    public void delete(Integer id) throws ComponentException, ServiceException {

        try {
            if (personMapperDTO.toDto(personDao.getPerson(id))   != null){
                Person personToDelete = new Person();
                personToDelete = personDao.getPerson(id);
                personDao.deletePerson(id);
            }
            else {
                ServiceException exc = new ServiceException();
                exc.setStatusCode(404);
                throw exc;
            }
        }
        catch (ComponentException e){
            ServiceException ex = new ServiceException();
            ex.setStatusCode(e.getStatusCode());
            throw ex;
        }
    }





}
