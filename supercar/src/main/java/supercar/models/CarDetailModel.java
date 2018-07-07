/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import supercar.entities.Car;
import supercar.entities.Lending;
import supercar.interfaces.IModel;

/**
 *
 * @author Patrick
 */
@Named("cardetail")
@SessionScoped
public class CarDetailModel extends IModel {

    private Car car;

    private Collection<Lending> lendings;

    public CarDetailModel() {
    }

    public void render() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Map<String, String> map = context.getExternalContext().getRequestParameterMap();
            long id = Long.parseLong(map.get("id"), 10);
            car = Cars.get(id);
            lendings = Lendings.getLendingByCarId(id);
        } catch (Exception e) {
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            try {
                context.redirect(context.getRequestContextPath() + "/");
            } catch (IOException ex) {
                Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Collection<Lending> getLendings() {
        return lendings;
    }

    public void setLendings(Collection<Lending> lendings) {
        this.lendings = lendings;
    }

    public void rent() {
        Calendar c = new GregorianCalendar();

        Lending lending = new Lending();
        lending.setCar(car);
        lending.setRentDate(c.getTimeInMillis());

        LoginHandler.getAccount().addLending(lending);
        Lendings.add(lending);

        Accounts.update(LoginHandler.getAccount());
    }
}
