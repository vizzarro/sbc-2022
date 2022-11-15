package it.aesys.courses.springboot.model.mapperdto;

public class PersonDTO {
    private String fiscalCodeNumber;

    public PersonDTO() {

    }

    public String getFiscalCodeNumber() {
        return fiscalCodeNumber;
    }

    public void setFiscalCodeNumber(String fiscalCodeNumber) {
        this.fiscalCodeNumber = fiscalCodeNumber;
    }
}
