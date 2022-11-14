package it.aesys.courses.springboot.personregistry.repository;

import it.aesys.courses.springboot.personregistry.models.Person;
import it.aesys.courses.springboot.personregistry.repository.exception.ComponentException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class PersonDao {

    private Map<Integer, Person> personMapDao = new HashMap<>();
    private Integer sequence;


    public PersonDao(){
        this.sequence = 0;
        this.personMapDao = new HashMap<>();
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

        if (id != null && !personMapDao.containsKey(id)){

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
