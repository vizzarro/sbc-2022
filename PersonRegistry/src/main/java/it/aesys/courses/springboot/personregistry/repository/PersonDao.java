package it.aesys.courses.springboot.personregistry.repository;

import it.aesys.courses.springboot.personregistry.models.Address;
import it.aesys.courses.springboot.personregistry.models.EnumAddress;
import it.aesys.courses.springboot.personregistry.models.EnumGender;
import it.aesys.courses.springboot.personregistry.models.Person;
import it.aesys.courses.springboot.personregistry.repository.exception.ComponentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class PersonDao {

    private Map<Integer, Person> personMapDao = new HashMap<>();
    private Integer sequence;

    @Autowired
    public PersonDao(){
        this.sequence = 0;
        this.personMapDao = new HashMap<>();

        Address gennaroAddress = new Address();
        gennaroAddress.setCivic("69");
        gennaroAddress.setHome(EnumAddress.RESIDENCE);
        gennaroAddress.setStreet("via dei crocifissi");
        gennaroAddress.setPostalCode(104);
        Person gennaro = new Person();
        gennaro.setId(1);
        gennaro.setName("gennaro");
        gennaro.setSurname("mosconi");
        gennaro.setBirthDate(new Date());
        gennaro.setAddress(gennaroAddress);
        gennaro.setGender(EnumGender.FEMALE);
        gennaro.setFiscalCode("gnrmsc13k547c");

        this.personMapDao.put(1, gennaro);
    }

    public Person createPerson (Person person) throws ComponentException {

        Integer newId = this.sequence++;

        if (person != null && !personMapDao.containsKey(person.getId())){
            personMapDao.put(person.getId(), person);
            return personMapDao.get(person.getId());
        }
        else {
            ComponentException ex = new ComponentException();
            ex.setStatusCode(400);
            throw ex;
        }
    }



    public Person getPerson (Integer id) throws ComponentException {

        if (id != null && personMapDao.containsKey(id)){

            return personMapDao.get(id);
        }
        else {
            ComponentException ex = new ComponentException();
            ex.setStatusCode(404);
            throw ex;
        }
    }
    public Person updatePerson (Integer id, Person person) throws ComponentException {

        if (id != null && !personMapDao.containsKey(id) && person != null){

            Person personToUpdate = new Person();
            personToUpdate = person;
            personMapDao.put(id, personToUpdate);
            return personToUpdate;
        }
        else {
            ComponentException ex = new ComponentException();
            ex.setStatusCode(404);
            throw ex;
        }
    }

    public void deletePerson (Integer id) throws ComponentException {

        if (id != null && personMapDao.containsKey(id)){

            Person personToDelete = new Person();
            //personToDelete = personMapDao.get(id);
            personMapDao.remove(id);
        }
        else {
            ComponentException ex = new ComponentException();
            ex.setStatusCode(404);
            throw ex;
        }
    }

    public Collection<Person> getAllPersons () throws ComponentException {

            return personMapDao.values();
        }

}
