package it.aesys.courses.springboot.lesson1.digregorio.controller;

import it.aesys.courses.springboot.lesson1.config.DigregorioConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("digregorio")
@Profile("devel")
public class DigregorioDevelController {


    private DigregorioConfig config;

    @Autowired
    public DigregorioDevelController(DigregorioConfig config){
        super();
        this.config = config;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String lesson() {
        StringBuilder builder = new StringBuilder();
        builder.append("<H1>Suka World !!!</H1>");
        return builder.toString();
    }
}
