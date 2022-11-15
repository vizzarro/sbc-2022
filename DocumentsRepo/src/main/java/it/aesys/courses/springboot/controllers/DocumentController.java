package it.aesys.courses.springboot.controllers;

import it.aesys.courses.springboot.models.Document;
import it.aesys.courses.springboot.models.dto.DocumentRequest;
import it.aesys.courses.springboot.services.DocumentService;
import it.aesys.courses.springboot.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/document")
public class DocumentController {

    DocumentService service;
    FileService fileService;

    @Autowired
    public DocumentController(DocumentService service, FileService fileService) {
        this.service = service;
        this.fileService = fileService;
    }

    @GetMapping
    public List<Document> getAll(){
        return (service.getAllDocuments());
    }

    @GetMapping("/{id}")
    public Document findDocument(@PathVariable Integer id) {
        return service.getDocumentById(id);
    }

    @GetMapping("/find")
    public List<Document> findDocumentByCf(String cf) {
        return service.getDocumentByCf(cf);
    }

    @PostMapping(consumes = "multipart/form-data")
    public Document createDocument(@ModelAttribute DocumentRequest request) throws IOException {
        return service.createDocument(request);
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable Integer id) {
        service.deleteDocument(id);
    }

    @PutMapping("/{id}")
    public Document updateDocument(@RequestBody DocumentRequest request,@PathVariable Integer id) {
        return service.updateDocument(request, id);
    }
}


