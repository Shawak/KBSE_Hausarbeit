/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import supercar.entities.Garage;
import supercar.abstracts.IModel;

/**
 *
 * @author Lukas Bernhold, Patrick Wiethoff
 */
@Named("garage")
@SessionScoped
public class GarageModel extends IModel {

    private Garage new_garage;

    private Garage change_garage;

    private String new_city;

    private String change_city;

    private Collection<Garage> garages;

    public String getNew_city() {
        if (new_garage.getPlz() == null) {
            new_city = "";
            return new_city;
        } else {
            new_city = PlzApi.getName(new_garage.getPlz());
            return new_city;
        }
    }

    public String getChange_city() {
        if (change_garage != null) {
            if (change_garage.getPlz() == null) {
                change_city = "";
                return change_city;
            } else {
                change_city = PlzApi.getName(change_garage.getPlz());
                return change_city;
            }
        }
        return change_city;
    }

    public Collection<Garage> getGarages() {
        return garages;
    }

    public Garage getNew_garage() {
        return new_garage;
    }

    public Garage getChange_garage() {
        return change_garage;
    }

    public GarageModel() {
        new_garage = new Garage();
    }

    @PostConstruct
    public void init() {
        garages = Garages.getAll();
    }

    public void add() {
        try {
            if (PlzApi.getName(new_garage.getPlz()).isEmpty()) {
                FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong Post Code!", "Wrong Post Code!"));
            } else {
                new_garage.setCity(new_city);
                garages.add(Garages.add(new_garage));
                new_garage = new Garage();
                FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_INFO, "Garage add!", "Garage add!"));
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:Garage not add!", "Error:Garage not add!"));
        }
    }

    public void change(Long id) {
        change_garage = Garages.get(id);
        change_city = change_garage.getCity();
    }

    public void change() {
        try {
            if (PlzApi.getName(change_garage.getPlz()).isEmpty()) {
                FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong Post Code!", "Wrong Post Code!"));
            }
            change_garage.setCity(change_city);
            change_garage = Garages.update(change_garage);
            garages = Garages.getAll();
            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_INFO, "arage change!", "Garage change!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:Garage not change!", "Error:Garage not change!"));
        }
    }

}
