package it.aesys.courses.springboot.lesson1.dicesare.controllers;


import it.aesys.courses.springboot.lesson1.config.DiCesareConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dicesare")
@Profile("devel")
public class DiCesareController {
    private DiCesareConfig config;

    @Autowired
    public DiCesareController(DiCesareConfig config){
        this.config=config;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String lesson() {
        StringBuilder builder = new StringBuilder();
        builder.append("<H1>Ciaooooo"+"</H1>");

        return builder.toString();
    }
}

