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
public class Lending extends IUniqueEntity {
    
    private long rentDate;
    private long returnDate;
    
    private long rentMileage;
    private long returnMileage;
    
    private String returnCommentary;
    
    @ManyToOne
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public long getRentDate() {
        return rentDate;
    }

    public void setRentDate(long rentDate) {
        this.rentDate = rentDate;
    }

    public long getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(long returnDate) {
        this.returnDate = returnDate;
    }

    public long getRentMileage() {
        return rentMileage;
    }

    public void setRentMileage(long rentMileage) {
        this.rentMileage = rentMileage;
    }

    public long getReturnMileage() {
        return returnMileage;
    }

    public void setReturnMileage(long returnMileage) {
        this.returnMileage = returnMileage;
    }

    public String getReturnCommentary() {
        return returnCommentary;
    }

    public void setReturnCommentary(String returnCommentary) {
        this.returnCommentary = returnCommentary;
    }
    
    public Lending() { }
    
}