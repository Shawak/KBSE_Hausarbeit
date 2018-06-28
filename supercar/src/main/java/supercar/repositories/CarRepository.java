/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.repositories;

import java.util.Collection;
import javax.ejb.Stateless;
import supercar.entities.Car;
import supercar.interfaces.IRepository;

/**
 *
 * @author Maxi
 */
@Stateless
public class CarRepository extends IRepository<Car> {

    public CarRepository() { }

    public Collection<Car> getAllActive(String order) {
        if(order.equals("licensePlate")||order.equals("color")||order.equals("model")||order.equals("pricePerDay"))
        {
            return query("select e from #table e where e.deactivated = 0 order by e."+order+"").all();
        }
        return null;
    }
}
