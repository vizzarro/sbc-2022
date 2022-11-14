package it.aesys.courses.springboot.personregistry.repository;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PersonDao {

    Map<Integer, models.Person> personMapDao = new HashMap<>();

    public models.Person createPerson (models.Person person){

        if (person != null && !personMapDao.containsKey(person.getId())){
            personMapDao.put(person.getId(), person);
            return personMapDao.get(person.getId);
        }
        ComponentException ex = new ComponentException();
        ex.setStatusCode(400);
        throw ex;
    }



    public models.Person getPerson (Integer id){

        if ( )

    }

}
