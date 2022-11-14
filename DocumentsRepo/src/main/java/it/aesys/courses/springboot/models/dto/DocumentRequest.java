package it.aesys.courses.springboot.models.dto;

import java.time.LocalDate;
public class DocumentRequest {

    private String nameFile;
    private String typeOfFile;
    private String typeOfDoc;
    private String file;
    private String fiscalCode;

    public DocumentRequest(String nameFile, String typeOfFile, String typeOfDoc, String file, String fiscalCode) {
        this.nameFile = nameFile;
        this.typeOfFile = typeOfFile;
        this.typeOfDoc = typeOfDoc;
        this.file = file;
        this.fiscalCode = fiscalCode;
    }

    public DocumentRequest() {
        super();
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getTypeOfFile() {
        return typeOfFile;
    }

    public void setTypeOfFile(String typeOfFile) {
        this.typeOfFile = typeOfFile;
    }

    public String getTypeOfDoc() {
        return typeOfDoc;
    }

    public void setTypeOfDoc(String typeOfDoc) {
        this.typeOfDoc = typeOfDoc;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }
}
