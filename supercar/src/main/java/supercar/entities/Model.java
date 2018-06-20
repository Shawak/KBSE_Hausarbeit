/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
    
    @OneToMany
    @JoinColumn(name="Model_ID")
    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
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
    
}
