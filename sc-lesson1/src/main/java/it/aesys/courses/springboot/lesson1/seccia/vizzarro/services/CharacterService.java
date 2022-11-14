package it.aesys.courses.springboot.lesson1.vizzarro.services;

import it.aesys.courses.springboot.lesson1.models.Character;
import it.aesys.courses.springboot.lesson1.models.mapperdto.CharacterDTO;
import it.aesys.courses.springboot.lesson1.models.mapperdto.CharacterMapperDTO;
import it.aesys.courses.springboot.lesson1.vizzarro.components.CharacterComponent;
import it.aesys.courses.springboot.lesson1.vizzarro.components.exceptions.ComponentException;
import it.aesys.courses.springboot.lesson1.vizzarro.services.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    private CharacterMapperDTO mapper;

    private CharacterComponent componentDao;


    @Autowired
    public CharacterService(CharacterMapperDTO mapper,CharacterComponent componentDao) {
        this.mapper = mapper;
        this.componentDao = componentDao;
    }

    public CharacterDTO create(CharacterDTO dto) throws ServiceException {
        System.out.println(dto.toString());

        try {
            return this.mapper.toDto( this.componentDao.create(this.mapper.toModel(dto)));
        } catch (ComponentException e) {
            ServiceException ex = new ServiceException(e);
            ex.setStatusCode(e.getStatusCode());
            throw ex;
        }


    }

    public CharacterDTO get(String uuid) throws ServiceException {

        try {
            return this.mapper.toDto( this.componentDao.get(uuid));
        } catch (ComponentException e) {
            ServiceException ex = new ServiceException(e);
            ex.setStatusCode(e.getStatusCode());
            throw ex;
        }


    }

}
