package it.aesys.courses.springboot.services;

import it.aesys.courses.springboot.components.DocumentComponent;
import it.aesys.courses.springboot.dao.impl.DaoDocumentImpl;
import it.aesys.courses.springboot.exception.InvalidInputException;
import it.aesys.courses.springboot.models.Document;
import it.aesys.courses.springboot.models.dto.DocumentRequest;
import it.aesys.courses.springboot.utils.FileUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Service
public class DocumentService {

    DocumentComponent repository;
    DaoDocumentImpl dao;
    FileUtil fileUtil;

    @Autowired
    public DocumentService(DocumentComponent repository, FileUtil fileUtil, DaoDocumentImpl dao) {
        this.repository = repository;
        this.fileUtil = fileUtil;
        this.dao = dao;
    }



    public Document createDocument(DocumentRequest request) throws IOException {
        if (validRequest(request)) {
            Document document = new Document();
            BeanUtils.copyProperties(request, document);
            document.setDataOfInput(LocalDate.now());
            document.setFile(fileUtil.upload(request.getFile()));
            return (repository.addDocument(document));
        }
        throw new InvalidInputException("All fields are required");
    }

    public List<Document> getAllDocuments() throws SQLException {
        return dao.findAll();
    }

    public List<Document> getDocumentByCf(String cf) {
        if (cf.length() == 16) {
            return repository.findByCf(cf);
        }
        throw new InvalidInputException("Invalid cf");
    }

    public Document getDocumentById(Integer id) {
        if (id != null) {
            return (repository.findById(id));
        }
        throw new InvalidInputException("Invalid id");
    }

    public void deleteDocument(Integer id) throws SQLException {
        if (id != null) {
            dao.delete(id);
        } else {
            throw new InvalidInputException("Invalid Id");
        }
    }

    public Document updateDocument(DocumentRequest request, Integer id) throws IOException {
        if (validRequest(request)) {
            Document document = repository.findById(id);
            document.setFile(fileUtil.upload(request.getFile()));
            BeanUtils.copyProperties(request, document);
            return (repository.editById(id, document));
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
