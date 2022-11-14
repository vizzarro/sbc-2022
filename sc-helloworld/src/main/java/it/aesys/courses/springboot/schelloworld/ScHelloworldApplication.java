package it.aesys.courses.springboot.schelloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping(path = "/hw")
@SpringBootApplication
public class ScHelloworldApplication {

	private static final Logger logger = LoggerFactory.getLogger(ScHelloworldApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ScHelloworldApplication.class, args);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String helloWorld() {

		return "<H1>HELLO WORLD!!!</H!>";
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			logger.info("Let's inspect the beans provided by Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				logger.info(beanName);
			}
		};
	}



}
