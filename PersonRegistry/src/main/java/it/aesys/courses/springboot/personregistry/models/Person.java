package it.aesys.courses.springboot.personregistry.models;

import java.util.Date;

public class Person {

    private String;
    private String;
    private String;
    private EnumGender gender;
    private EnumAddress address;
    private Date birthDate;
    private String cellNumber;
    private Integer id;

    public Person() {
    }

    public EnumGender getGender() {
        return gender;
    }

    public void setGender(EnumGender gender) {
        this.gender = gender;
    }

    public EnumAddress getAddress() {
        return address;
    }

    public void setAddress(EnumAddress address) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
