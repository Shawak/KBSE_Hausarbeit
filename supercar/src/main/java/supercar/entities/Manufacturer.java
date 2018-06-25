/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.entities;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import supercar.core.PlzApi;
import supercar.interfaces.IUniqueEntity;
import supercar.validator.PLZ;

/**
 *
 * @author Maxi
 */
@Entity
public class Manufacturer extends IUniqueEntity {
    
    @NotNull(message = "Manufactory may not be empty")
    private String name;
    
    @PLZ
    private int plz;
    
    //@NotNull(message = "Wrong Post Code")
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

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
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
    
    public Manufacturer(String name, int plz, String street, String contactInfo, String city) {
        this.name = name;
        this.plz = plz;
        this.street = street;
        this.contactInfo = contactInfo;
        this.city=city;
    }
    
}