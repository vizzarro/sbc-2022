package it.aesys.courses.springboot.personregistry.models.mapper;

import it.aesys.courses.springboot.personregistry.models.EnumGender;

import java.util.Date;

public class PersonDTO {

    private String name;
    private String surname;
    private Integer fiscalCode;
    private EnumGender gender;
    private String address;
    private Date birthDate;
    private String callNumber;


    public PersonDTO() {

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

    public Integer getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(Integer fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public EnumGender getGender() {
        return gender;
    }

    public void setGender(EnumGender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public void setCallNumber(String callNumber) {
        this.callNumber = callNumber;
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
                ", callNumber='" + callNumber + '\'' +
                '}';
    }
}
