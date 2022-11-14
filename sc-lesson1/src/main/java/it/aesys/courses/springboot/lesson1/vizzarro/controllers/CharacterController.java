package it.aesys.courses.springboot.lesson1.vizzarro.controllers;

import it.aesys.courses.springboot.lesson1.models.Character;
import it.aesys.courses.springboot.lesson1.models.ClassType;
import it.aesys.courses.springboot.lesson1.models.mapperdto.CharacterDTO;
import it.aesys.courses.springboot.lesson1.models.request.CharacterRequest;
import it.aesys.courses.springboot.lesson1.vizzarro.services.CharacterService;
import it.aesys.courses.springboot.lesson1.vizzarro.services.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vizzarro/character")
public class CharacterController {

    private CharacterService service;


    @Autowired
    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @PostMapping
    public CharacterDTO create( @RequestBody CharacterRequest request) throws ServiceException {

        return service.create(request.getCharacter());

    }

    @GetMapping("{uuid}")
    public CharacterDTO get( @PathVariable("uuid") String uuid) throws ServiceException {

        return service.get(uuid);

    }


}
