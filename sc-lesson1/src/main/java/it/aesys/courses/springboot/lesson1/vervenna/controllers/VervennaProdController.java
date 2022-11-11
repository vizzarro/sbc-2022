package it.aesys.courses.springboot.lesson1.vervenna.controllers;

import it.aesys.courses.springboot.lesson1.config.VervennaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vervenna")
@Profile("production")
public class VervennaProdController {

    private VervennaConfig config;

    @Autowired
    public VervennaProdController(VervennaConfig config){
        this.config = config;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String lesson() {
        StringBuilder builder = new StringBuilder();
        builder.append("<H1>SPRING BOOT "+config.getAppName()+" </H1>");
        builder.append("<H2>"+config.getDescription()+"</H2>");
        builder.append("<H3>"+config.getVersion()+"</H3>");
        return builder.toString();
    }
}
