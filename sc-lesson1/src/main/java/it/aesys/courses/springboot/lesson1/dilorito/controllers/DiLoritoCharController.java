package it.aesys.courses.springboot.lesson1.dilorito.controllers;

import it.aesys.courses.springboot.lesson1.models.Character;
import it.aesys.courses.springboot.lesson1.models.ClassType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dilorito/character")
public class DiLoritoCharController {

    @PostMapping
    public Character create(Character character){

        Character c = new Character();
        c.setName("Conan");
        c.setType(ClassType.WARRIOR);
        c.setLevel(20);
        return new Character();
    }
}
