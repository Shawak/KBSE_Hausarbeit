/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import supercar.entities.Manufacturer;
import supercar.abstracts.IModel;

/**
 *
 * @author Lukas Bernhold, Patrick Wiethoff
 */
@Named("manufacturer")
@SessionScoped
public class ManufacturerModel extends IModel {

    private Manufacturer new_manufacturer;

    private Manufacturer change_manufacturer;

    private String new_city;

    private String change_city;

    private Collection<Manufacturer> manufacturers;

    public String getNew_city() {
        if (new_manufacturer.getPlz() == null) {
            new_city = "";
            return new_city;
        } else {
            new_city = PlzApi.getName(new_manufacturer.getPlz());
            return new_city;
        }
    }

    public String getChange_city() {
        if (change_manufacturer != null) {
            if (change_manufacturer.getPlz() == null) {
                change_city = "";
                return change_city;
            } else {
                try {
                    change_city = PlzApi.getName(change_manufacturer.getPlz());
                } catch (Exception ex) {
                    change_city = "";
                    Logger.getLogger(ManufacturerModel.class.getName()).log(Level.SEVERE, null, ex);
                    return change_city;
                }
                if (change_city == null) {
                    change_city = "";
                    return change_city;
                }
                change_city = change_city.substring(0, change_city.length() - 1).substring(1);
                return change_city;
            }
        }
        return change_city;
    }

    public Collection<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public Manufacturer getNew_manufacturer() {
        return new_manufacturer;
    }

    public Manufacturer getChange_manufacturer() {
        return change_manufacturer;
    }

    public ManufacturerModel() {
        new_manufacturer = new Manufacturer();
    }

    @PostConstruct
    public void init() {
        manufacturers = Manufacturers.getAll();
    }

    public void add() {
        try {
            if (PlzApi.getName(new_manufacturer.getPlz()).isEmpty()) {
                FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong Post Code!", "Wrong Post Code!"));
            }
            new_manufacturer.setCity(new_city);
            manufacturers.add(Manufacturers.add(new_manufacturer));
            new_manufacturer = new Manufacturer();
            FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_INFO, "Manufactory add!", "Manufactory add!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:Manufactory not add!", "Error:Manufactory not add!"));
        }
    }

    public void change(Long id) {
        change_manufacturer = Manufacturers.get(id);
        change_city = change_manufacturer.getCity();
    }

    public void change() {
        try {
            if (PlzApi.getName(change_manufacturer.getPlz()).isEmpty()) {
                FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong Post Code!", "Wrong Post Code!"));
            }
            change_manufacturer.setCity(change_city);
            change_manufacturer = Manufacturers.update(change_manufacturer);
            manufacturers = Manufacturers.getAll();
            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_INFO, "Manufactory change!", "Manufactory change!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:Manufactory not change!", "Error:Manufactory not change!"));
        }
    }

}
