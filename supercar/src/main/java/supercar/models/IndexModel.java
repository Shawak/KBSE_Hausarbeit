/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import java.util.Collection;
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

    public IndexModel() {
        order = "licensePlate";
        sort = "ASC";
    }

    public Collection<Car> getCars() {
        return Cars.getAllFree(order,sort);
    }

    public String carDetail(Long id) {
        System.out.println(id);
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
    
}
