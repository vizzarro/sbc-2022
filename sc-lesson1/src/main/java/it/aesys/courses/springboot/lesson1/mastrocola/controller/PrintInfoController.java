package it.aesys.courses.springboot.lesson1.mastrocola.controller;

import it.aesys.courses.springboot.lesson1.config.MastroConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/mastro")
public class PrintInfoController {
    private MastroConfig conf;

    @Autowired
    public PrintInfoController(MastroConfig conf) {
        this.conf = conf;
    }
    @RequestMapping(method = RequestMethod.GET)
    public String lesson() {
        StringBuilder builder = new StringBuilder();
        builder.append("<H1>SPRING BOOT "+conf.getAppName()+" </H1>");
        builder.append("<H2>"+conf.getDescription()+"</H2>");
        builder.append("<H3>"+conf.getVersion()+"</H3>");
        return builder.toString();
    }
}
