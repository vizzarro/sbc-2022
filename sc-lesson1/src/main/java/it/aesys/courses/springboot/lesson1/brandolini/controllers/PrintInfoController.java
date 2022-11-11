package it.aesys.courses.springboot.lesson1.brandolini.controllers;
import it.aesys.courses.springboot.lesson1.config.BrandoliniConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("brandolini")
public class PrintInfoController {
    private BrandoliniConfig config;

    public PrintInfoController(BrandoliniConfig config){
        super();
        this.config = config;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String lesson() {
        StringBuilder builder = new StringBuilder();
        builder.append("<H1>App name :"+config.getAppName()+" </H1>");
        builder.append("<H2>Description :"+config.getDescription()+"</H2>");
        builder.append("<H3>Version :"+config.getVersion()+"</H3>");
        return builder.toString();
    }

}
