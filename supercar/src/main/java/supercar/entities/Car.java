/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import supercar.interfaces.IUniqueEntity;

/**
 *
 * @author Maxi
 */
@Entity
public class Car extends IUniqueEntity {
    
    private String licensePlate;
    private float pricePerDay;
    private boolean deactivated;
    private String picture;
    private String color;
    
    @ManyToOne
    private Model model;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public float getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    
    public boolean isDeactivated() {
        return deactivated;
    }

    public void setDeactivated(boolean deactivated) {
        this.deactivated = deactivated;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
    public Car() { }
    
    public Car(String licensePlate, float pricePerDay, Model model, String picture, String color) {
        this.licensePlate = licensePlate;
        this.pricePerDay = pricePerDay;
        this.model = model;
        this.picture=picture;
        this.color=color;
    }
    
}
