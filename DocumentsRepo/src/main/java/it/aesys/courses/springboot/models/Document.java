package it.aesys.courses.springboot.models;

import java.time.LocalDate;

public class Document {
    private int idDoc;
    private String nameFile;
    private LocalDate dataOfInput;
    private String typeOfFile;
    private String typeOfDoc;
    private String file;
    private String fiscalCode;

    public Document() {
        super();
    }
    public Document(int idDoc, String nameFile, LocalDate dataOfInput, String typeOfFile, String typeOfDoc, String file, String fiscalCode) {
        this.idDoc = idDoc;
        this.nameFile = nameFile;
        this.dataOfInput = dataOfInput;
        this.typeOfFile = typeOfFile;
        this.typeOfDoc = typeOfDoc;
        this.file = file;
        this.fiscalCode = fiscalCode;
    }
    public int getIdDoc() {
        return idDoc;
    }
    public void setIdDoc(int idDoc) {
        this.idDoc = idDoc;
    }
    public String getNameFile() {
        return nameFile;
    }
    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }
    public LocalDate getDataOfInput() {
        return dataOfInput;
    }
    public void setDataOfInput(LocalDate dataOfInput) {
        this.dataOfInput = dataOfInput;
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
