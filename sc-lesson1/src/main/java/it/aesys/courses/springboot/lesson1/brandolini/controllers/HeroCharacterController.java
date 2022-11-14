package it.aesys.courses.springboot.lesson1.brandolini.controllers;

import it.aesys.courses.springboot.lesson1.brandolini.components.exceptions.ComponentExceptionBrandolini;
import it.aesys.courses.springboot.lesson1.brandolini.models.mapperdto.HeroCharacterDTO;
import it.aesys.courses.springboot.lesson1.brandolini.models.request.HeroCharacterRequest;
import it.aesys.courses.springboot.lesson1.brandolini.services.HeroCharacterService;
import it.aesys.courses.springboot.lesson1.brandolini.services.exceptions.ServiceExceptionBrandolini;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;

@RestController
@RequestMapping("brandolini/herocharacter")
//@SpringBootApplication
public class HeroCharacterController {
//    private static final Logger logger = LoggerFactory.getLogger(HeroCharacterController.class);
//
//    public static void main(String[] args) {
//        SpringApplication.run(HeroCharacterController.class, args);
//    }
//
//
//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            logger.info("Let's inspect the beans provided by Spring Boot:");
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                logger.info(beanName);
//            }
//        };
//    }




    private HeroCharacterService service;

    @Autowired
    public HeroCharacterController(HeroCharacterService service){
        this.service = service;
    }

    @PostMapping
    public HeroCharacterDTO addHeroCharacter(@RequestBody HeroCharacterRequest heroCharacterRequest) throws ServiceExceptionBrandolini {

        return service.create(heroCharacterRequest.getHeroCharacterDTO());
    }


    @GetMapping("{uuid}")
    public HeroCharacterDTO getHeroCharacter( @PathVariable("uuid") String uuid) throws ComponentExceptionBrandolini, ServiceExceptionBrandolini {

        return service.get(uuid);
    }

    @GetMapping(value="all")
    public Collection<HeroCharacterDTO> getAllHeroCharacter() throws ComponentExceptionBrandolini, ServiceExceptionBrandolini {

        return service.getAll();
    }

    @PutMapping
    public HeroCharacterDTO updateHeroCharacter( @RequestBody HeroCharacterRequest heroCharacterRequest) throws ComponentExceptionBrandolini, ServiceExceptionBrandolini {

        return service.update(heroCharacterRequest.getHeroCharacterDTO());
    }

    @DeleteMapping("{uuid}")
    public String deleteHeroCharacter( @PathVariable("uuid") String uuid) throws ComponentExceptionBrandolini, ServiceExceptionBrandolini {

        service.delete(uuid);
        return "Character Deleted";
    }

    @GetMapping("/random")
    public HeroCharacterDTO getRandomHeroCharacter() throws ComponentExceptionBrandolini, ServiceExceptionBrandolini {

        return service.random();

    }


}
