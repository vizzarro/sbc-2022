package it.aesys.courses.springboot.components;

import it.aesys.courses.springboot.exception.AlreadyExistsException;
import it.aesys.courses.springboot.exception.NotFoundException;
import it.aesys.courses.springboot.models.Document;

import java.util.*;

import java.util.stream.Collectors;

public class DocumentComponent {

    private List<Document> documentList;

    private Integer sequence;

    public DocumentComponent() {
        this.documentList = new ArrayList<>();
        this.sequence = 0;
    }

    public Document addDocument(Document document) throws AlreadyExistsException {
        List<Document> docsByTypeAndCf = documentList.stream()
                .filter(doc -> doc.getFiscalCode().equals(document.getFiscalCode()))
                .filter(doc -> doc.getTypeOfDoc().equals(document.getTypeOfDoc()))
                .collect(Collectors.toList());
        if (docsByTypeAndCf.isEmpty()) {
            ++sequence;
            document.setIdDoc(sequence);
            documentList.add(document);
            return document;
        } throw new AlreadyExistsException("Document already exists");
    }

    public Document findById(Integer id) throws NotFoundException {
        Optional<Document> found = this.documentList.stream().
                filter(document -> document.getIdDoc().equals(id))
                .findFirst();
        if(found.isPresent()) {
            return found.get();
        } throw new NotFoundException("Document not found");
    }

    public Document findByCf(String cf) {
        return null;
    }


}
