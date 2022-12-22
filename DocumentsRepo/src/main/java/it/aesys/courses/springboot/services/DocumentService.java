package it.aesys.courses.springboot.services;

import it.aesys.courses.springboot.models.Document;
import it.aesys.courses.springboot.models.dto.DocumentRequest;
import it.aesys.courses.springboot.repository.DocumentRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface DocumentService {

    Document createDocument (DocumentRequest request) throws IOException ;
    List<Document> getDocumentByCf(String fc);
    List<Document> getAllDocuments();
    Document getDocumentById (Integer id);
    void deleteDocument(Integer id);
    Document updateDocument(DocumentRequest request, Integer id) throws IOException;





}
