package it.aesys.courses.springboot.personregistry.models;

import java.util.Date;

public class PersonDTO {

    private String name;
    private String surname;
    private String fiscalCode;
    private EnumGender gender;
    private Address address;
    private Date birthDate;

    private String cellNumber;


    public PersonDTO() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public EnumGender getGender() {
        return gender;
    }

    public void setGender(EnumGender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCallNumber() {
        return cellNumber;
    }

    public void setCellNumber(String callNumber) {
        this.cellNumber = cellNumber;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fiscalCode=" + fiscalCode +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", birthDate=" + birthDate +
                ", callNumber='" + cellNumber + '\'' +
                '}';
    }
}
