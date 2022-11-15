package it.aesys.courses.springboot.services;

import it.aesys.courses.springboot.components.DocumentComponent;
import it.aesys.courses.springboot.models.Document;
import it.aesys.courses.springboot.models.dto.DocumentRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DocumentService {

    DocumentComponent repository;
    FileService fileService;

    @Autowired
    public DocumentService(DocumentComponent repository, FileService fileService) {
        this.repository = repository;
        this.fileService = fileService;
    }

    public Document createDocument(DocumentRequest request) {
        Document document = new Document();
        BeanUtils.copyProperties(request,document);
        document.setDataOfInput(LocalDate.now());
        return(repository.addDocument(document));
    }
}
