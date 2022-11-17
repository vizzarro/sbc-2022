package it.aesys.courses.springboot.service;

import it.aesys.courses.springboot.exception.BadInputException;
import it.aesys.courses.springboot.model.mapperDTO.PersonDTO;

public interface PersonService {

    PersonDTO create(PersonDTO dto);
    PersonDTO get(String fiscalCodeNumber);
    PersonDTO delete (String fiscalCodeNumber);
    PersonDTO update(PersonDTO dto);

}
