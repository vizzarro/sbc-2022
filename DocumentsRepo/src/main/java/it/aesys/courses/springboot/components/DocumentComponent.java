package it.aesys.courses.springboot.components;

import it.aesys.courses.springboot.exception.AlreadyExistsException;
import it.aesys.courses.springboot.exception.NotFoundException;
import it.aesys.courses.springboot.models.Document;
import org.springframework.stereotype.Component;

import java.util.*;

import java.util.stream.Collectors;

@Component
public class DocumentComponent {

    private List<Document> documentList;

    private Integer sequence;

    public DocumentComponent() {
        this.documentList = new ArrayList<>();
        this.sequence = 0;
    }

    public Document addDocument(Document document) {
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

    public Document findById(Integer id) {
        Optional<Document> found = this.documentList.stream().
                filter(document -> document.getIdDoc().equals(id))
                .findFirst();
        if(found.isPresent()) {
            return found.get();
        } throw new NotFoundException("Document not found");
    }

    public Document findByCf(String cf) {
        Optional<Document> found = this.documentList.stream()
                .filter(doc -> cf.equals(doc.getFiscalCode()))
                .findFirst();
        if(found.isPresent()){
            return found.get();
        }throw new NotFoundException("Document not found");
    }

    public List<Document> findAll(){
        return this.documentList;
    }
    public Document editById(Integer id, Document document) {

        if(this.findById(id)!=null){
            documentList.set(id, document);
            return document;
        }throw new NotFoundException("Document not found");

    }

    public void deleteById(Integer id) {
        if(this.findById(id) != null) {
            documentList.remove(id);
        }else throw new NotFoundException("Document not found");
    }

}
