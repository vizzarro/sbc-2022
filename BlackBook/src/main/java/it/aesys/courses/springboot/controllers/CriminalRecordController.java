package it.aesys.courses.springboot.controllers;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evaluation")
@Profile("devel")
public class CriminalRecordController {
}
