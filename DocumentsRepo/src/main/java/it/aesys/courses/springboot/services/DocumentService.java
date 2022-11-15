package it.aesys.courses.springboot.services;

import it.aesys.courses.springboot.components.DocumentComponent;
import it.aesys.courses.springboot.exception.InvalidInputException;
import it.aesys.courses.springboot.models.Document;
import it.aesys.courses.springboot.models.dto.DocumentRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
    public List<Document> findByCf(String cf){
        if(cf.length() == 16){
            return repository.findByCf(cf);
        } throw new InvalidInputException("Invalid cf");
    }

    public Document getById(Integer id){
        if(id!=null){
            return repository.findById(id);

        }throw new InvalidInputException("Invalid id");
    }


}
