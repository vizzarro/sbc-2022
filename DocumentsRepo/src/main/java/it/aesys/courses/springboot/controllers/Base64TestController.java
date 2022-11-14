package it.aesys.courses.springboot.controllers;

import it.aesys.courses.springboot.services.TestBase64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/test")
public class Base64TestController {

    @Autowired
    private TestBase64 service;

    @PostMapping
    public String upload(@RequestBody MultipartFile file) throws IOException {
        return service.upload(file);
    }

    @GetMapping
    public byte[] download(@RequestParam String encoded) {
        return service.download(encoded);
    }
}
