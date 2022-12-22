package it.aesys.courses.springboot.services;

import it.aesys.courses.springboot.components.DocumentComponent;
import it.aesys.courses.springboot.dao.impl.DaoDocumentImpl;
import it.aesys.courses.springboot.exception.InvalidInputException;
import it.aesys.courses.springboot.exception.NotFoundException;
import it.aesys.courses.springboot.models.Document;
import it.aesys.courses.springboot.models.dto.DocumentRequest;
import it.aesys.courses.springboot.repository.DocumentRepository;
import it.aesys.courses.springboot.utils.FileUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService{

    //DocumentComponent repository;
    //DaoDocumentImpl dao;

    DocumentRepository documentRepository;
    FileUtil fileUtil;

    @Autowired
    public DocumentServiceImpl( FileUtil fileUtil, DocumentRepository documentRepository) {

        this.fileUtil = fileUtil;
        this.documentRepository = documentRepository;
    }


    @Override
    @Transactional
    public Document createDocument(DocumentRequest request) throws IOException {
        if (validRequest(request)) {
            Document document = new Document();
            BeanUtils.copyProperties(request, document);
            document.setDataOfInput(LocalDate.now());
            document.setFile(fileUtil.upload(request.getFile()));

            return documentRepository.save(document);
        }
        throw new InvalidInputException("All fields are required");
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public List<Document> getDocumentByCf(String cf)  {
        if (cf.length() == 16) {
            return documentRepository.findByFiscalCode(cf);
        }
        throw new InvalidInputException("Invalid cf");
    }

    public Document getDocumentById(Integer id)  {
        if (id != null) {
            Optional<Document> documentOptional = documentRepository.findById(id);
            if (documentOptional.isEmpty()){
                throw new NotFoundException("Document with id: " + id + " not found");
            }
            return documentOptional.get();
        }
        throw new InvalidInputException("Invalid id");
    }

    public void deleteDocument(Integer id) {
        if (id != null) {

            Optional<Document> documentToDelete = documentRepository.findById(id);
            if (documentToDelete.isEmpty()){
                throw new NotFoundException("The document with id " + id + " was not found");
            }
            documentRepository.delete(documentToDelete.get());
        } else {
            throw new InvalidInputException("Invalid Id");
        }
    }

    public Document updateDocument(DocumentRequest request, Integer id) throws IOException {
        if (validRequest(request)) {
            Document document = this.getDocumentById(id);

                document.setFile(fileUtil.upload(request.getFile()));
                BeanUtils.copyProperties(request, document);
                return documentRepository.save(document);

        }
        throw new InvalidInputException("All fields are required");
    }

    private Boolean validRequest(DocumentRequest request) {

        Object[] fields = {request.getNameFile(),
                request.getTypeOfDoc(),
                request.getTypeOfFile(),
                request.getFile()};

        if(request.getFiscalCode() != null && request.getFiscalCode().length()==16) {
            for ( Object field: fields) {
                if (field == null) {
                    return false;
                }
            } return true;
        } throw new InvalidInputException("Invalid Fiscal Code");
    }
}
