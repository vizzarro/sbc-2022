package it.aesys.courses.springboot.personregistry.request;

import it.aesys.courses.springboot.personregistry.models.PersonDTO;
import org.springframework.stereotype.Component;

@Component
public class PersonRequest {

    private PersonDTO personDTO = new PersonDTO();

    public PersonRequest() {
        super();
    }


    public PersonDTO getPersonDTO() {
        return personDTO;
    }

    public void setPersonDTO(PersonDTO personDTO) {
        this.personDTO = personDTO;
    }

}
