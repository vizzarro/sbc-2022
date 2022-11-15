package it.aesys.courses.springboot.model.request;

import it.aesys.courses.springboot.model.mapperDTO.PersonDTO;

public class PersonRequest {
    private PersonDTO personDto = new PersonDTO();

    public PersonRequest() {
        super();
    }

    public PersonDTO getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDTO personDto) {
        this.personDto = personDto;
    }
}
