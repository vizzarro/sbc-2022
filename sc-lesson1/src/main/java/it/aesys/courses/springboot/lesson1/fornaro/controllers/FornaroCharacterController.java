package it.aesys.courses.springboot.lesson1.fornaro.controllers;

import it.aesys.courses.springboot.lesson1.models.Character;
import it.aesys.courses.springboot.lesson1.models.mapperdto.CharacterDTO;
import it.aesys.courses.springboot.lesson1.models.request.CharacterRequest;
import it.aesys.courses.springboot.lesson1.fornaro.components.FornaroCharacterComponent;
import it.aesys.courses.springboot.lesson1.fornaro.services.FornaroCharacterService;
import it.aesys.courses.springboot.lesson1.fornaro.services.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("fornaro/character")
@Profile("devel")
public class FornaroCharacterController {

    private FornaroCharacterService service;


    @Autowired
    public FornaroCharacterController(FornaroCharacterService service, FornaroCharacterComponent component) {
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

    @GetMapping("/findAll")
    public Collection<Character> findAllCharacter() throws ServiceException {
        return service.findAllCharacter();
    }

    @DeleteMapping("/delete/{uuid}")
    public void delete(@PathVariable("uuid") String uuid) throws ServiceException {
        service.delete(uuid);
    }

    @PutMapping("update/{uuid}")
    public CharacterDTO update(@PathVariable("uuid") String uuid, @RequestBody CharacterRequest request) throws ServiceException {
        return service.update(request.getCharacter());
    }
}

