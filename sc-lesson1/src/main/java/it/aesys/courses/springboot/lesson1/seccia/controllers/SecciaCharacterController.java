package it.aesys.courses.springboot.lesson1.seccia.controllers;

import it.aesys.courses.springboot.lesson1.models.Character;
import it.aesys.courses.springboot.lesson1.models.mapperdto.CharacterDTO;
import it.aesys.courses.springboot.lesson1.models.request.CharacterRequest;
import it.aesys.courses.springboot.lesson1.seccia.components.SecciaCharacterComponent;
import it.aesys.courses.springboot.lesson1.seccia.components.exception.ComponentException;
import it.aesys.courses.springboot.lesson1.seccia.services.SecciaCharacterService;
import it.aesys.courses.springboot.lesson1.seccia.services.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("seccia/character")
public class SecciaCharacterController{

    private SecciaCharacterService service;


    @Autowired
    public SecciaCharacterController(SecciaCharacterService service, SecciaCharacterComponent component) {
        this.service = service;
    }

    @PostMapping
    public CharacterDTO create(@RequestBody CharacterRequest request) throws ServiceException {
        return service.create(request.getCharacter());
    }

    @GetMapping("{uuid}")
    public CharacterDTO get( @PathVariable("uuid") String uuid) throws ServiceException {
        return service.get(uuid);
    }

    @GetMapping("find")
    public Collection<Character> findAllChar() throws ServiceException {
        return service.findAll();
    }

    @DeleteMapping("{uuid}")
    public void delete (@PathVariable("uuid") String uuid) throws ServiceException {
        service.delete(uuid);
    }

    @PutMapping("{uuid}")
    public CharacterDTO update(@PathVariable ("uuid") String uuid, @RequestBody CharacterRequest request) throws ServiceException {
        return service.update(request.getCharacter());
    }
}

