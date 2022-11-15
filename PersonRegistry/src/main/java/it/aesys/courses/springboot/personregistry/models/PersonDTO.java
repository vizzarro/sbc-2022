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

    public PersonDTO(String n, String s, String fC, EnumGender g, Address a, Date bD, String cN) {
        this.name = n;
        this.surname = s;
        this.fiscalCode = fC;
        this.gender = g;
        this.address = a;
        this.birthDate = bD;
        this.cellNumber = cN;
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

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
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
                ", cellNumber='" + cellNumber + '\'' +
                '}';
    }
}
