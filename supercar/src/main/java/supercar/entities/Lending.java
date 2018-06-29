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
    
    private Long rentDate;
    private Long returnDate;
    
    private Long rentMileage;
    private Long returnMileage;
    
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

    public void setRentDate(Long rentDate) {
        this.rentDate = rentDate;
    }

    public Long getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Long returnDate) {
        this.returnDate = returnDate;
    }

    public Long getRentMileage() {
        return rentMileage;
    }

    public void setRentMileage(Long rentMileage) {
        this.rentMileage = rentMileage;
    }

    public Long getReturnMileage() {
        return returnMileage;
    }

    public void setReturnMileage(Long returnMileage) {
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