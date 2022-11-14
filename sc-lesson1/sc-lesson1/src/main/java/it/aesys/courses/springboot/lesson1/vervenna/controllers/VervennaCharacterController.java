package it.aesys.courses.springboot.lesson1.vervenna.controllers;

import it.aesys.courses.springboot.lesson1.models.Character;
import it.aesys.courses.springboot.lesson1.models.mapperdto.CharacterDTO;
import it.aesys.courses.springboot.lesson1.models.request.CharacterRequest;
import it.aesys.courses.springboot.lesson1.vervenna.components.VervennaCharacterComponent;
import it.aesys.courses.springboot.lesson1.vervenna.services.VervennaCharacterService;
import it.aesys.courses.springboot.lesson1.vervenna.services.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("vervenna/character")
public class VervennaCharacterController {

    private VervennaCharacterService service;


    @Autowired
    public VervennaCharacterController(VervennaCharacterService service, VervennaCharacterComponent component) {
        this.service = service;
    }

    @PostMapping
    public CharacterDTO create(@RequestBody CharacterRequest request) throws ServiceException {
        return service.create(request.getCharacter());
    }

    @GetMapping("/{uuid}")
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

    @PutMapping("/{uuid}")
    public void update(@PathVariable String uuid, @RequestBody CharacterRequest request) throws ServiceException {
        service.update(request.getCharacter());
    }
}

