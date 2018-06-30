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
import supercar.core.PlzApi;
import supercar.entities.Manufacturer;
import supercar.interfaces.IModel;

/**
 *
 * @author Patrick
 */
@Named("manufacturer")
@SessionScoped
public class ManufacturerModel extends IModel {

    private Manufacturer new_manufacturer;

    private Manufacturer change_manufacturer;

    private String new_city;

    private String change_city;

    private Collection<Manufacturer> manufacturers;

    private final PlzApi plzApi;

    public String getNew_city() {
        if (new_manufacturer.getPlz() == null) {
            new_city = "";
            return new_city;
        } else {
            try {
                new_city = plzApi.getName(new_manufacturer.getPlz());
            } catch (Exception ex) {
                new_city = "";
                Logger.getLogger(ManufacturerModel.class.getName()).log(Level.SEVERE, null, ex);
                return "Post Code Error";
            }
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
                    change_city = plzApi.getName(change_manufacturer.getPlz());
                } catch (Exception ex) {
                    change_city = "";
                    Logger.getLogger(ManufacturerModel.class.getName()).log(Level.SEVERE, null, ex);
                    return "Post Code Error";
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
        plzApi = new PlzApi();
    }

    @PostConstruct
    public void init() {
        //manufacturers = new ArrayList<>();
        manufacturers = Manufacturers.getAll();
    }

    public void add() {
        try {
            new_manufacturer.setCity(new_city);
            manufacturers.add(Manufacturers.add(new_manufacturer));
            new_manufacturer = new Manufacturer();
            FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_INFO, "Manufactory add!", "Manufactory add!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:Manufactory not add!", "Error:Manufactory not add!"));
        }
    }

    public void change(Long id) {
        //change_manufacturer=manufacturers.stream().filter((Manufacturer o) -> o.getId().equals(id)).findFirst().get();

        change_manufacturer = Manufacturers.get(id);
        change_city = change_manufacturer.getCity();
    }

    public void change() {
        try {
            change_manufacturer.setCity(change_city);
            change_manufacturer = Manufacturers.update(change_manufacturer);
            //manufacturers=manufacturers.stream().map((Manufacturer o) -> Objects.equals(o.getId(), change_manufacturer.getId())?change_manufacturer:o).collect(toList());
            manufacturers = Manufacturers.getAll();
            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_INFO, "Manufactory change!", "Manufactory change!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:Manufactory not change!", "Error:Manufactory not change!"));
        }
    }

}
