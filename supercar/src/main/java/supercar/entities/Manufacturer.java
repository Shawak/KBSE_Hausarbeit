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
    
    @NotNull(message = "Street may not be empty")
    private String street;
    
    private String contactInfo;
    
    //City kann einfacher angezeigt wereden; steht nicht in DB
    @Transient
    private String city;
    @Transient
    private PlzApi plzApi;
    
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
    
    public String getCity(){
        city= plzApi.getName(this.plz);
        if(city == null){
            return "";
        }
        city= city.substring(0, city.length() - 1).substring(1);
        return city;
    }
    
    public Manufacturer() {
        plzApi=new PlzApi();
    }
    
    public Manufacturer(String name, int plz, String street, String contactInfo) {
        this.name = name;
        this.plz = plz;
        this.street = street;
        this.contactInfo = contactInfo;
        plzApi=new PlzApi();
    }
    
}