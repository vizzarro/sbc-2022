package it.aesys.courses.springboot.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_doc")
    private Integer idDoc;
    @Column(name="name_file")
    private String nameFile;
    @Column(name="data_of_input")
    private LocalDate dataOfInput;
    @Column(name="type_of_file", columnDefinition = "enum('PNG','JPEG','PDF')")
    private TypeOfFile typeOfFile;
    @Column(name="type_of_doc", columnDefinition = "enum('ID_CARD', 'DRIVER_LICENSE')")
    private TypeOfDoc typeOfDoc;
    @Column(name="file",columnDefinition = "TEXT")
    private String file;
    @Column(name="fiscal_code")
    private String fiscalCode;

    public Document() {
        super();
    }
    public Document(Integer idDoc, String nameFile, LocalDate dataOfInput, TypeOfFile typeOfFile, TypeOfDoc typeOfDoc, String file, String fiscalCode) {
        this.idDoc = idDoc;
        this.nameFile = nameFile;
        this.dataOfInput = dataOfInput;
        this.typeOfFile = typeOfFile;
        this.typeOfDoc = typeOfDoc;
        this.file = file;
        this.fiscalCode = fiscalCode;
    }
    public Integer getIdDoc() {
        return idDoc;
    }
    public void setIdDoc(Integer idDoc) {
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
    public TypeOfFile getTypeOfFile() {
        return typeOfFile;
    }
    public void setTypeOfFile(TypeOfFile typeOfFile) {
        this.typeOfFile = typeOfFile;
    }
    public TypeOfDoc getTypeOfDoc() {
        return typeOfDoc;
    }
    public void setTypeOfDoc(TypeOfDoc typeOfDoc) {
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
