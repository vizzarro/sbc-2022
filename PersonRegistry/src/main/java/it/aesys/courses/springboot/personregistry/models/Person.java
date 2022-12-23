package it.aesys.courses.springboot.personregistry.models;

import it.aesys.courses.springboot.personregistry.CustomValidators.FiscalCodeCheckAnnotation;
import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "person")
public class Person {
    @NotNull(message = "The name field can't be null")
    @Column(name = "name")
    private String name;
    @NotNull(message = "The surname field can't be null")

    @Column(name = "surname")
    private String surname;
    @NotNull(message = "The fiscalcode field can't be null")
    @FiscalCodeCheckAnnotation
    @Id
    @Column(name = "fiscalcode")
    private String fiscalCode;
    @Column(name = "gender", columnDefinition = "enum('M','F')")
    @Enumerated(EnumType.STRING)
    private EnumGender gender;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "cell_number")
    private String cellNumber;
    //@Column(name = "address_id")
    //private Integer addressId;


    public Person() {
        super();
    }

    public Person(String name, String  surname, String fiscalCode, EnumGender gender, Address address, LocalDate birthDate, String cellNumber) {
        this.name = name;
        this.surname = surname;
        this.fiscalCode = fiscalCode;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.cellNumber = cellNumber;}
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    /*public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
*/
    public String getName(){return name;}

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
 }
