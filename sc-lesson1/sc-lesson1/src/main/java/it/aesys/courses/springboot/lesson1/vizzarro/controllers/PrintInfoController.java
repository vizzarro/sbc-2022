package it.aesys.courses.springboot.lesson1.vizzarro.controllers;

import it.aesys.courses.springboot.lesson1.config.VizConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vizzarro")
@Profile("devel")
public class PrintInfoController {


    private VizConfig config;

    @Autowired
    public PrintInfoController(VizConfig config) {
        super();
        this.config = config;
    }




    @RequestMapping(method = RequestMethod.GET)
    public String lesson() {
        StringBuilder builder = new StringBuilder();
        builder.append("<H1>HELLO WORLD !!!</H1>");
        return builder.toString();
    }

}
