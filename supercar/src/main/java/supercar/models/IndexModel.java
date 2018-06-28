/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import java.util.Collection;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import supercar.entities.Car;
import supercar.interfaces.IModel;
import supercar.repositories.CarRepository;

/**
 *
 * @author Maxi
 */
@Named("index")
@SessionScoped
public class IndexModel extends IModel {
    
      private String order;
    
    public IndexModel() { 
        order ="licensePlate";
    }
  

    public Collection<Car> getCars()
    {
        System.out.println(order);
        return Cars.getAllActive(order);
    }
    
    public String test(Long id)
    {
        System.out.println(id);
       return "/supercar/faces/index.xhtml";
    }
    
     public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        System.out.println("setOrder --------------------------------");
        this.order = order;
    }
    
}