package it.aesys.courses.springboot.model.mapperdto;

import it.aesys.courses.springboot.model.Person;

public class PersonMapperDTO {

    public PersonDTO toDto(Person person) {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setFiscalCodeNumber(person.getFiscalCodeNumber());
        return personDTO;
    }

    public Person toModel(PersonDTO dto) {
        Person person = new Person();
        person.setFiscalCodeNumber(dto.getFiscalCodeNumber());
        return person;
    }

}