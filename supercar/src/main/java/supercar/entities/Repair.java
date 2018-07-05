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
public class Repair extends IUniqueEntity {

    String description;
    
    Long repairStartDate;
    Long repairEndDate;
    
    @ManyToOne
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getRepairStartDate() {
        return repairStartDate;
    }

    public void setRepairStartDate(Long repairStartDate) {
        this.repairStartDate = repairStartDate;
    }

    public Long getRepairEndDate() {
        return repairEndDate;
    }

    public void setRepairEndDate(Long repairEndDate) {
        this.repairEndDate = repairEndDate;
    }
    
    public boolean isActive() {
        return repairEndDate == 0;
    }
    
    public Repair() { }
    
}