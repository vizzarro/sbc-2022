package it.aesys.courses.springboot.lesson1.seccia.controllers;

import it.aesys.courses.springboot.lesson1.config.SecciaConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seccia")
@Profile("devel")
public class SecciaDevController {


    private SecciaConfig config;

    @Autowired
    public SecciaDevController(SecciaConfig config) {
        super();
        this.config = config;
    }


    @GetMapping
    public String lesson() {
        StringBuilder builder = new StringBuilder();
        builder.append("<H1> Antonio Seccia Web App </H1>");
        return builder.toString();
    }

}
