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

    public CarRepository() {
    }

    public Collection<Car> getAllActive(String order, String sort) {
        if ((order.equals("licensePlate") || order.equals("color") || order.equals("model") || order.equals("pricePerDay")) && (sort.equals("ASC") || sort.equals("DESC"))) {
            return query("select e from #table e where e.deactivated = 0 order by e." + order + " " + sort).all();
        }
        return null;
    }

    public Collection<Car> getAllFree(String order, String sort) {
        // alle autos die nicht beim kunden oder in der Werkstatt sind
        if ((order.equals("licensePlate") || order.equals("color") || order.equals("model") || order.equals("pricePerDay")) && (sort.equals("ASC") || sort.equals("DESC"))) {
            return query("select e from #table e where e.deactivated = 0 and e not in (select f.car from Lending f where f.returnDate IS NULL) and e not in (select g.car from Repair g where g.repairEndDate IS NULL) order by e." + order + " " + sort)
                    .all();
        }
        return null;
    }

    public Collection<Car> getCarAtRepair(String order, String sort) {
        // alle autos die nicht beim kunden oder in der Werkstatt sind
        if ((order.equals("licensePlate") || order.equals("color") || order.equals("model") || order.equals("pricePerDay")) && (sort.equals("ASC") || sort.equals("DESC"))) {
            return query("select e from #table e where e.deactivated = 0 and e in (select f.car from Lending f where f.returnDate IS NULL) order by e." + order + " " + sort)
                    .all();
        }
        return null;
    }

    public Collection<Car> getCarAtLending(String order, String sort) {
        // alle autos die nicht beim kunden oder in der Werkstatt sind
        if ((order.equals("licensePlate") || order.equals("color") || order.equals("model") || order.equals("pricePerDay")) && (sort.equals("ASC") || sort.equals("DESC"))) {
            return query("select e from #table e where e.deactivated = 0 and e in (select g.car from Repair g where g.repairEndDate IS NULL) order by e." + order + " " + sort)
                    .all();
        }
        return null;
    }

}
