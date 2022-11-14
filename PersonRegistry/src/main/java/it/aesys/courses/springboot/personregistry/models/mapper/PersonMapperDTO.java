package it.aesys.courses.springboot.personregistry.models.mapper;

import it.aesys.courses.springboot.personregistry.models.EnumAddress;
import it.aesys.courses.springboot.personregistry.models.Person;
import it.aesys.courses.springboot.personregistry.models.PersonDTO;
import org.springframework.stereotype.Component;

@Component
public class PersonMapperDTO {

    public PersonDTO toDto(Person person) {

        PersonDTO dto = new PersonDTO();

        dto.setName(person.getName());
        dto.setSurname(person.getSurname());
        dto.setFiscalCode(person.getFiscalCode());
        dto.setGender(person.getGender());
        dto.setAddress(person.getAddress().toString());
        dto.setBirthDate(person.getBirthDate());
        dto.setCellNumber(person.getCellNumber());

        return dto;
    }

    public Person toModel(PersonDTO dto) {

        Person p = new Person();

        p.setName(dto.getName());
        p.setSurname(dto.getSurname());
        p.setFiscalCode(dto.getFiscalCode());
        p.setGender(dto.getGender());
        p.setAddress(EnumAddress.valueOf(dto.getAddress()));
        p.setBirthDate(dto.getBirthDate());
        p.setCellNumber(dto.getCallNumber());

        return p;
    }

}
