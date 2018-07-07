/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import supercar.interfaces.IUniqueEntity;
import supercar.validator.LicensePlate;

/**
 *
 * @author Maxi
 */
@Entity
public class Car extends IUniqueEntity {

    @LicensePlate
    private String licensePlate;

    @NotNull(message = "Price per Day may not be empty")
    @DecimalMin(value = "0.00", message = "Price per Day must be more expensive then 0.00$")
    @Digits(integer = 99, fraction = 2, message = "Price per Day may only have 2 decimal")
    private Float pricePerDay;

    private boolean deactivated;
    private String picture;

    @NotNull(message = "Color may not be empty")
    private String color;

    @ManyToOne
    private Model model;

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Float getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Float pricePerDay) {
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

    public Car() {
    }

    public Car(String licensePlate, Float pricePerDay, Model model, String picture, String color) {
        this.licensePlate = licensePlate;
        this.pricePerDay = pricePerDay;
        this.model = model;
        this.picture = picture;
        this.color = color;
    }

}
