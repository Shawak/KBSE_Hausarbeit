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
public class Model extends IUniqueEntity {
    
    private String name;
    private int horsepower;
    private int cubicCapacity;
    
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

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getCubicCapacity() {
        return cubicCapacity;
    }

    public void setCubicCapacity(int cubicCapacity) {
        this.cubicCapacity = cubicCapacity;
    }
    
    public Model() { }
    
    public Model(String name, Manufacturer manufacturer, int horsepower, int cubicCapacity) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.horsepower = horsepower;
        this.cubicCapacity = cubicCapacity;
    }
    
}
