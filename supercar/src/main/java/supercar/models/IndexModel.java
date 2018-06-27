/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import java.util.Collection;
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
public class IndexModel extends IModel {
    
    public IndexModel() { }
    
    public Collection<Car> getCars()
    {
        return Cars.getAll();
    }
    
    public String test(Long id)
    {
        System.out.println(id);
       return "/supercar/faces/index.xhtml";
    }
}