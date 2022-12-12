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
import java.util.Optional;

@Service
public class DocumentServiceImpl {

    DocumentComponent repository;
    DaoDocumentImpl dao;
    FileUtil fileUtil;

    @Autowired
    public DocumentServiceImpl(DocumentComponent repository, FileUtil fileUtil, DaoDocumentImpl dao) {
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
            return (dao.add(document));
        }
        throw new InvalidInputException("All fields are required");
    }

    public List<Document> getAllDocuments() throws SQLException {
        return dao.findAll();
    }

    public List<Document> getDocumentByCf(String cf) throws SQLException {
        if (cf.length() == 16) {
            return dao.findByCf(cf);
        }
        throw new InvalidInputException("Invalid cf");
    }

    public Optional<Document> getDocumentById(Integer id) throws SQLException {
        if (id != null) {
            return (dao.find(id));
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

    public Document updateDocument(DocumentRequest request, Integer id) throws IOException, SQLException {
        if (validRequest(request)) {
            Optional<Document> document = dao.find(id);
            if (document.isPresent()) {
                document.get().setFile(fileUtil.upload(request.getFile()));
                BeanUtils.copyProperties(request, document.get());
                return (dao.edit(id, document.get()));
            }
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
