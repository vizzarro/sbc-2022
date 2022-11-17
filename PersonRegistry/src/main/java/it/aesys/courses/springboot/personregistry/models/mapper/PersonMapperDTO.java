package it.aesys.courses.springboot.personregistry.models.mapper;

import it.aesys.courses.springboot.personregistry.models.EnumAddress;
import it.aesys.courses.springboot.personregistry.models.Person;
import it.aesys.courses.springboot.personregistry.models.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonMapperDTO {

    private AddressMapperDTO addressMapperDTO;

    @Autowired
    public PersonMapperDTO(AddressMapperDTO addressMapperDTO){
        this.addressMapperDTO = addressMapperDTO;
    }
    public PersonDTO toDto(Person person) {

        PersonDTO dto = new PersonDTO();

        dto.setName(person.getName());
        dto.setSurname(person.getSurname());
        dto.setFiscalCode(person.getFiscalCode());
        dto.setGender(person.getGender());
        dto.setAddress(addressMapperDTO.toDto(person.getAddress()));
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
        p.setAddress(addressMapperDTO.toModel(dto.getAddress()));
        p.setBirthDate(dto.getBirthDate());
        p.setCellNumber(dto.getCellNumber());

        return p;
    }
}
