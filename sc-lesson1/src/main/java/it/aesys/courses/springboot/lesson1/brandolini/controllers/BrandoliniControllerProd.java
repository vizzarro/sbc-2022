package it.aesys.courses.springboot.lesson1.brandolini.controllers;

import it.aesys.courses.springboot.lesson1.config.BrandoliniConfig;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("brandolini")
@Profile("production")
public class BrandoliniControllerProd {

    private BrandoliniConfig config;

    public BrandoliniControllerProd(BrandoliniConfig config){
        super();
        this.config = config;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String lesson() {
        StringBuilder builder = new StringBuilder();
        builder.append("<H2> HELLO WORLD!!! THIS IS PRODUCTION</H2>");
        return builder.toString();
    }
}
