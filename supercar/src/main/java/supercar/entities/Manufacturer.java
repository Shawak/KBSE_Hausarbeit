/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import supercar.interfaces.IUniqueEntity;

/**
 *
 * @author Maxi
 */
@Entity
public class Manufacturer extends IUniqueEntity {
    
    private String name;
    
    private int plz;
    private String street;
    
    private String contactInfo;

    @OneToMany
    @JoinColumn(name="Manufacturer_ID")
    private List<Model> models;

    public List<Model> getModels() {
        return models == null ? new ArrayList<>() : models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
    
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
    
    public Manufacturer() { }
    
    public Manufacturer(String name, int plz, String street, String contactInfo) {
        this.name = name;
        this.plz = plz;
        this.street = street;
        this.contactInfo = contactInfo;
    }
    
}