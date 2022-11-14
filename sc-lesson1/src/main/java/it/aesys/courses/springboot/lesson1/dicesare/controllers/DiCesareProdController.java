package it.aesys.courses.springboot.lesson1.dicesare.controllers;

import it.aesys.courses.springboot.lesson1.config.DiCesareConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dicesare")
@Profile("production")
public class DiCesareProdController {
    private DiCesareConfig config;

    @Autowired
    public DiCesareProdController(DiCesareConfig config){
        this.config=config;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String lesson() {
        StringBuilder builder = new StringBuilder();
        builder.append("<H1>SPRING BOOT "+config.getAppName()+" </H1>");
        builder.append("<H2>Version: "+config.getVersion()+"</H2>");
        builder.append("<H3>"+config.getDescription()+"</H3>");
        return builder.toString();
    }
}
