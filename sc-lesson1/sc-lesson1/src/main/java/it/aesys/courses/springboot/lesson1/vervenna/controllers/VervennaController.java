package it.aesys.courses.springboot.lesson1.vervenna.controllers;

import it.aesys.courses.springboot.lesson1.config.VervennaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vervenna")
@Profile("devel")
public class VervennaController {

    private VervennaConfig config;

    @Autowired
    public VervennaController(VervennaConfig config){
        this.config = config;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String lesson() {
        StringBuilder builder = new StringBuilder();
        builder.append("<H2>HELLO WORLD !!!</H2>");
        return builder.toString();
    }
}
