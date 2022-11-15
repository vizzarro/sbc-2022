package it.aesys.courses.springboot.controllers;

import it.aesys.courses.springboot.models.Document;
import it.aesys.courses.springboot.models.dto.DocumentRequest;
import it.aesys.courses.springboot.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/document")
public class DocumentController {
    DocumentService service;

    @Autowired
    public DocumentController(DocumentService service) {
        this.service = service;
    }

    @PostMapping
    public Document createDocument(@RequestBody DocumentRequest request) {
        return service.createDocument(request);
    }

    @GetMapping("/{id}")
    public Document findDocument(@PathVariable Integer id) {
        return service.getById(id);
    }

    @GetMapping("/cf")
    public List<Document> getByCf(String cf) {
        return service.findByCf(cf);
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable Integer id) {
        service.deleteDocument(id);
    }

    @PostMapping("/{id}")
    public Document updateDocument(@RequestBody DocumentRequest request, Integer id) {
        return service.updateDocument(request, id);
    }
}


