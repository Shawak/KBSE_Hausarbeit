/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import supercar.interfaces.IUniqueEntity;

/**
 *
 * @author Maxi
 */
@Entity
public class Manufacturer extends IUniqueEntity {
    
    @NotNull
    private String name;
    
    private Integer plz;
    //@NotNull
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
    
    public Manufacturer() { }
    
    public Manufacturer(String name, int plz, String street, String contactInfo) {
        this.name = name;
        this.plz = plz;
        this.street = street;
        this.contactInfo = contactInfo;
    }
    
}