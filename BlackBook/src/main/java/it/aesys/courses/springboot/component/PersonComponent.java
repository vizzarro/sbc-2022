package it.aesys.courses.springboot.component;

import it.aesys.courses.springboot.model.Person;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PersonComponent {

    private Map<String, Person> mapPerson = new HashMap<>();

   public Person create(Person person){
         if(!mapPerson.containsKey(person.getFiscalCodeNumber())){
             mapPerson.put(person.getFiscalCodeNumber(), person);
             return mapPerson.get(person.getFiscalCodeNumber());
         }
         return null;
    }

    public Person get(String fiscalCodeNumber) {
       if (mapPerson.containsKey(fiscalCodeNumber)){
           return mapPerson.get(fiscalCodeNumber);
       }
       return null;
    }

    public Person delete (String fiscalCodeNumber) {
        if (mapPerson.containsKey(fiscalCodeNumber)){
            return mapPerson.remove(fiscalCodeNumber);
        }
        return null;
    }

    public Person update(Person person){

        if(mapPerson.containsKey(person.getFiscalCodeNumber())){
            Person updated = new Person();
            updated.setFiscalCodeNumber(person.getFiscalCodeNumber());
            return mapPerson.put(updated.getFiscalCodeNumber(), updated);
        }
        return null;
    }

    //UPDATE = CREATE REPORT ???
}

