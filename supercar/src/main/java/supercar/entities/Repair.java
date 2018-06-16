/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.entities;

import javax.persistence.Entity;
import supercar.interfaces.IUniqueEntity;

/**
 *
 * @author Maxi
 */
@Entity
public class Repair extends IUniqueEntity {

    String description;
    
    long repairStartDate;
    long repairEndDate;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getRepairStartDate() {
        return repairStartDate;
    }

    public void setRepairStartDate(long repairStartDate) {
        this.repairStartDate = repairStartDate;
    }

    public long getRepairEndDate() {
        return repairEndDate;
    }

    public void setRepairEndDate(long repairEndDate) {
        this.repairEndDate = repairEndDate;
    }
    
    public boolean isActive() {
        return repairEndDate == 0;
    }
    
    public Repair() { }
    
}