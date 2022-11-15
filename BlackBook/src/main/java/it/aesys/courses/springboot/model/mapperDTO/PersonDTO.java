package it.aesys.courses.springboot.model.mapperDTO;


public class PersonDTO {

    private String fiscalCodeNumber;

    public PersonDTO() {
    }

    public void setFiscalCodeNumber(String fiscalCodeNumber) {
        this.fiscalCodeNumber = fiscalCodeNumber;
    }

    public String getFiscalCodeNumber() {
        return fiscalCodeNumber;
    }

}
