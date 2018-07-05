/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import supercar.entities.Car;
import supercar.interfaces.IModel;

/**
 *
 * @author Maxi
 */
@Named("index")
@SessionScoped
public class IndexModel extends IModel {

    private String order;
    private String sort;
    
    private List<Long> arr;

    public IndexModel() {
        order = "licensePlate";
        sort = "ASC";
        arr = new ArrayList<>();
    }

    public Collection<Car> getCars() {
        Collection<Car> cars = Cars.getAllFree(order,sort);
        arr = cars.stream().map(c->c.getId()).collect(Collectors.toList());
        cars.addAll(Cars.getCarAtLending(order, sort));
        cars.addAll(Cars.getCarAtRepair(order, sort));
        return cars;
    }

    public String carDetail(Long id) {
        return "cardetail.xhtml?id=" + id +"&faces-redirect=true";
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
    
    public boolean Free(long id){
        return arr.stream().filter(o -> o==id).findFirst().isPresent();
    }
    
}
