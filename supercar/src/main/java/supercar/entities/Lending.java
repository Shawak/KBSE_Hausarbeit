/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.entities;

import java.util.Date;
import javax.persistence.Column;
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
    @Column(name = "ACCOUNT_ID")
    private Long accountId;

    @ManyToOne
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Long getRentDate() {
        return this.rentDate;
    }

    public Date getRentDateAsDate() {
        if (this.rentDate == null) {
            return null;
        }
        return new Date(this.rentDate);
    }

    public void setRentDate(Long rentDate) {
        this.rentDate = rentDate;
    }

    public Long getReturnDate() {
        return this.returnDate;
    }

    public Date getReturnDateAsDate() {
        if (this.returnDate == null) {
            return null;
        }
        return new Date(this.returnDate);
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

    public Long getAccountId() {
        return accountId;
    }

    public Lending() {
    }

    public Lending(Long rentDate, Long returnDate, Long rentMileage, Long returnMileage, String returnCommentary, Car car) {
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.rentMileage = rentMileage;
        this.returnMileage = returnMileage;
        this.returnCommentary = returnCommentary;
        this.car = car;
    }
}
