package it.aesys.courses.springboot.lesson1.vizzarro.controllers;

import it.aesys.courses.springboot.lesson1.config.VizConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vizzarro")
@Profile("production")
public class PrintInfoProdController {


    private VizConfig config;

    @Autowired
    public PrintInfoProdController(VizConfig config) {
        super();
        this.config = config;
    }




    @RequestMapping(method = RequestMethod.GET)
    public String lesson() {
        StringBuilder builder = new StringBuilder();
        builder.append("<H1>SPRING BOOT "+config.getAppName()+" </H1>");
        builder.append("<H2>"+config.getDescription()+"</H2>");
        builder.append("<H3>Version : "+config.getVersion()+"</H3>");
        return builder.toString();
    }
}
