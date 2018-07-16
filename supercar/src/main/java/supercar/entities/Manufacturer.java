/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import supercar.abstracts.IUniqueEntity;
import supercar.validator.PLZ;

/**
 *
 * @author Lukas Bernhold, Maximilian Nussbaum, Patrick Wiethoff
 */
@Entity
public class Manufacturer extends IUniqueEntity {

    @NotNull(message = "Manufactory may not be empty")
    private String name;

    @PLZ
    private Integer plz;

    private String city;

    @NotNull(message = "Street may not be empty")
    private String street;

    private String contactInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlz() {
        return plz;
    }

    public void setPlz(Integer plz) {
        this.plz = plz;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Manufacturer() {
    }

    public Manufacturer(String name, Integer plz, String city, String street, String contactInfo) {
        this.name = name;
        this.plz = plz;
        this.city = city;
        this.street = street;
        this.contactInfo = contactInfo;
    }

}
