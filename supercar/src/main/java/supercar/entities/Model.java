/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import supercar.interfaces.IUniqueEntity;

/**
 *
 * @author Maxi
 */
@Entity
public class Model extends IUniqueEntity {
    
    @NotNull(message = "Model may not be empty")
    private String name;
    
    @NotNull(message = "Horsepower may not be empty")
    //stehen lass int ist default 0
    private Integer horsepower;
    
    @NotNull(message = "Cubic Capacity may not be empty")
    private Integer cubicCapacity;
    
    @ManyToOne
    private Manufacturer manufacturer;

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public Integer getCubicCapacity() {
        return cubicCapacity;
    }

    public void setCubicCapacity(Integer cubicCapacity) {
        this.cubicCapacity = cubicCapacity;
    }
    
    public Model() { }
    
    public Model(String name, Manufacturer manufacturer, Integer horsepower, Integer cubicCapacity) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.horsepower = horsepower;
        this.cubicCapacity = cubicCapacity;
    }
    
}
