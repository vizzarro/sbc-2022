package it.aesys.courses.springboot.services;

import it.aesys.courses.springboot.models.Document;
import it.aesys.courses.springboot.models.dto.DocumentRequest;
import it.aesys.courses.springboot.repository.DocumentRepository;

import java.util.List;
import java.util.Optional;

public interface DocumentService {

    Document create (DocumentRequest request);
    List<Document> getDocumentByCf(String fc);
    List<Document> getAllDocuments();
    Optional<Document> getDocumentById (Integer id);
    void deleteDocument(Integer id);
    Document updateDocument(DocumentRequest request, Integer id);





}
