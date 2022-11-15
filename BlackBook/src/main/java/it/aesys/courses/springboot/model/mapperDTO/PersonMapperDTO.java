package it.aesys.courses.springboot.model.mapperDTO;

import it.aesys.courses.springboot.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapperDTO {

    public PersonDTO toDto(Person person)  {
        PersonDTO dto = new PersonDTO();

        dto.setFiscalCodeNumber(person.getFiscalCodeNumber());

        return dto;
    }

    public Person toModel (PersonDTO dto){
        Person person = new Person();

        person.setFiscalCodeNumber(dto.getFiscalCodeNumber());

        return person;
    }
}
