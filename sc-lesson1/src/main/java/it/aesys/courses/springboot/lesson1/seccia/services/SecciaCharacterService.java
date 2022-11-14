package it.aesys.courses.springboot.lesson1.seccia.services;

import it.aesys.courses.springboot.lesson1.models.Character;
import it.aesys.courses.springboot.lesson1.models.mapperdto.CharacterDTO;
import it.aesys.courses.springboot.lesson1.models.mapperdto.CharacterMapperDTO;
import it.aesys.courses.springboot.lesson1.seccia.components.SecciaCharacterComponent;
import it.aesys.courses.springboot.lesson1.seccia.components.exception.ComponentException;
import it.aesys.courses.springboot.lesson1.seccia.services.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SecciaCharacterService {

    private CharacterMapperDTO mapper;

    private SecciaCharacterComponent componentDao;


    @Autowired
    public SecciaCharacterService(CharacterMapperDTO mapper, SecciaCharacterComponent componentDao) {
        this.mapper = mapper;
        this.componentDao = componentDao;
    }

    public CharacterDTO create(CharacterDTO dto) throws ServiceException {
        try {
            return this.mapper.toDto(this.componentDao.create(this.mapper.toModel(dto)));
        } catch (ComponentException e) {
            ServiceException ex = new ServiceException(e);
            ex.setStatusCode(e.getStatusCode());
            throw ex;
        }
    }

    public CharacterDTO get(String uuid) throws ServiceException {
        try {
            return this.mapper.toDto(this.componentDao.get(uuid));
        } catch (ComponentException e) {
            ServiceException ex = new ServiceException(e);
            ex.setStatusCode(e.getStatusCode());
            throw ex;
        }
    }

    public CharacterDTO update(CharacterDTO dto) throws ServiceException {

        try {
            return this.mapper.toDto(this.componentDao.update(this.mapper.toModel(dto)));
        } catch (ComponentException e) {
            ServiceException ex = new ServiceException();
            ex.setStatusCode(e.getStatusCode());
            throw ex;
        }
    }

    public void delete(String uuid) throws ServiceException {
        try {
            this.mapper.toDto(this.componentDao.delete(uuid));
        } catch (ComponentException e) {
            ServiceException ex = new ServiceException();
            ex.setStatusCode(e.getStatusCode());
            throw ex;
        }
    }

    public Collection<Character> findAll() throws ServiceException {
        try {
            return componentDao.findAll();
        } catch (ComponentException e) {
            ServiceException ex = new ServiceException();
            ex.setStatusCode(e.getStatusCode());
            throw ex;
        }
    }
}
