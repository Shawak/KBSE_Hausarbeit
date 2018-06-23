/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import supercar.interfaces.IUniqueEntity;
import supercar.validator.PLZ;

/**
 *
 * @author Maxi
 */
@Entity
public class Manufacturer extends IUniqueEntity {
    
    @NotNull
    private String name;
    
    @NotNull
    @PLZ
    //stehen lass int ist default 0
    private Integer plz;
    
    @NotNull
    private String street;
    
    //@NotNull
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
    
    public Manufacturer() { }
    
    public Manufacturer(String name, Integer plz, String street, String contactInfo) {
        this.name = name;
        this.plz = plz;
        this.street = street;
        this.contactInfo = contactInfo;
    }
    
}