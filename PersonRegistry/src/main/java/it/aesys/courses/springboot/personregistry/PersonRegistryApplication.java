package it.aesys.courses.springboot.personregistry;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/")
@SpringBootApplication

public class PersonRegistryApplication {


	public static void main(String[] args) {

		SpringApplication.run(PersonRegistryApplication.class, args);
	}

}
