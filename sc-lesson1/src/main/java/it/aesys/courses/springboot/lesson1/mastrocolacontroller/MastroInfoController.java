package it.aesys.courses.springboot.lesson1.mastrocolacontroller;

import it.aesys.courses.springboot.lesson1.config.MastroConfig;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mastrocola")
@Profile("devel")
public class MastroInfoController {
    private MastroConfig conf;

 }
