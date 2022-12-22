/*package it.aesys.courses.springboot.models.mapper;

import it.aesys.courses.springboot.exception.InvalidInputException;
import it.aesys.courses.springboot.models.Document;
import it.aesys.courses.springboot.models.dto.DocumentRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;

public class DocumentMapper {

    public DocumentRequest toDto (Document document){

        DocumentRequest documentRequest = new DocumentRequest();

        documentRequest.setNameFile(document.getNameFile());
        documentRequest.setFile(document.getFile());
        documentRequest.setTypeOfFile(document.getTypeOfFile());
        documentRequest.setTypeOfDoc(document.getTypeOfDoc());
        documentRequest.setFiscalCode(document.getFiscalCode());

        return documentRequest;
    }

    public Document toModel (DocumentRequest documentRequest){

        Document document = new Document();
        document.setNameFile(documentRequest.getNameFile());
        document.setFile(documentRequest.getFile());
        document.setTypeOfFile(documentRequest.getTypeOfFile());
        document.setTypeOfDoc(documentRequest.getTypeOfDoc());
        document.setFiscalCode(documentRequest.getFiscalCode());
        return document;
    }

    private MultipartFile toMultiPartFile (String string, Document document) {

        String extension;
        if (document.getTypeOfFile().toString().equals("JPG")) {
            extension = "image/jpeg";
        } else if (document.getTypeOfFile().toString().equals("PDF")) {
            extension = "application/pdf";
        } else if (document.getTypeOfFile().toString().equals("PNG")) {
            extension = "image/png";
        } else throw new InvalidInputException("Invalid File Type");

        byte[] decodedBytes = Base64.getDecoder().decode(string);
        byte[] bytes = string.getBytes();
        InputStream is = new ByteArrayInputStream(bytes);
        MultipartFile file = ("file", "filename.txt", "text/plain", is);
        MultipartFile multipartFile = MultipartFile.(string )

        return
    }




    }




}
*/