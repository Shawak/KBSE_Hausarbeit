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
import javax.validation.constraints.NotNull;
import supercar.interfaces.IUniqueEntity;
import supercar.validator.PLZ;

/**
 *
 * @author Maxi
 */
@Entity
public class Garage extends IUniqueEntity {

    @NotNull(message = "Garage may not be empty")
    private String name;

    @PLZ
    private Integer plz;
    @NotNull(message = "Street may not be empty")
    private String street;
    private String city;

    private String contactInfo;

    @OneToMany
    @JoinColumn(name = "Garage_ID")
    private List<Repair> repairs;

    public List<Repair> getRepairs() {
        return repairs == null ? new ArrayList<>() : repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    
    public void addRepair(Repair repair){
        this.repairs.add(repair);
    }

    public Garage() {
    }

    public Garage(String name, Integer plz, String city, String street, String contactInfo) {
        this.name = name;
        this.plz = plz;
        this.city = city;
        this.street = street;
        this.contactInfo = contactInfo;
    }

}
