package it.aesys.courses.springboot.lesson1.caterina.controllers;

import it.aesys.courses.springboot.lesson1.config.CaterinaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caterina")
public class PrintInfoController {

    private CaterinaConfig config;

    @Autowired
    public PrintInfoController(CaterinaConfig config){
        super();
        this.config = config;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String lesson() {
        StringBuilder builder = new StringBuilder();
        builder.append("<H1>SPRING BOOT "+ config.getAppName() +" </H1>");
        builder.append("<H2>"+ config.getDescription() +"</H2>");
        builder.append("<H3>"+ config.getVersion() +"</H2>");
        return builder.toString();
    }



}
