package it.aesys.courses.springboot.service.impl;

import it.aesys.courses.springboot.component.PersonComponent;
import it.aesys.courses.springboot.exception.BadInputException;
import it.aesys.courses.springboot.model.Report;
import it.aesys.courses.springboot.model.mapperDTO.PersonDTO;
import it.aesys.courses.springboot.model.mapperDTO.PersonMapperDTO;
import it.aesys.courses.springboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonMapperDTO mapper;

    private PersonComponent component;

    @Autowired
    public PersonServiceImpl(PersonMapperDTO mapper, PersonComponent component){
        this.mapper = mapper;
        this.component = component;
    }
    @Override
    public PersonDTO create(PersonDTO dto) {
        return this.mapper.toDto(this.component.create(this.mapper.toModel(dto)));
    }

    @Override
    public PersonDTO get(String fiscalCodeNumber) {
        return this.mapper.toDto(this.component.get(fiscalCodeNumber));
    }

    @Override
    public PersonDTO delete(String fiscalCodeNumber) {
        return this.mapper.toDto(this.component.delete(fiscalCodeNumber));
    }

    @Override
    public PersonDTO update(PersonDTO dto) {
        return this.mapper.toDto(this.component.update(this.mapper.toModel(dto)));
    }
}
