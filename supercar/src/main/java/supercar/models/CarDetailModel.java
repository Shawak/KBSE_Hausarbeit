/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import supercar.entities.Car;
import supercar.interfaces.IModel;

/**
 *
 * @author Patrick
 */
@Named("cardetail")
@RequestScoped
public class CarDetailModel extends IModel{

    private Car car;

    public CarDetailModel() {
    }
    
    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> map = context.getExternalContext().getRequestParameterMap();
        long id = Long.parseLong(map.get("id"),10);
        car = Cars.get(id);
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
}