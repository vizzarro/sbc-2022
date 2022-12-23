package it.aesys.courses.springboot.personregistry.models;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {

    @Column(name="street")
    public String street;
    @Column(name="civic")
    public String civic;
    @Column(name="postalcode")
    public Integer postalCode;
    @Column(name ="home", columnDefinition = "enum('RESIDENCE','DOMICILE')")
    @Enumerated(EnumType.STRING)
    public EnumAddress home;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id")
    public Integer addressId;

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCivic() {
        return civic;
    }

    public void setCivic(String civic) {
        this.civic = civic;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public EnumAddress getHome() {
        return home;
    }

    public void setHome(EnumAddress home) {
        this.home = home;
    }

    public Integer getAddressId() {
        return addressId;
    }
}
