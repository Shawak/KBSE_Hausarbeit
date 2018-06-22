/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import supercar.entities.Manufacturer;
import supercar.interfaces.IModel;

/**
 *
 * @author Patrick
 */
@Named("manufactury")
@SessionScoped
public class ManufacturyModel extends IModel {
    
    private List<Integer> plz_api;
    
    private Manufacturer manufactury;
    
    private List<Manufacturer> manufacturer;

    public List<Manufacturer> getManufacturer() {
        return manufacturer;
    }

    public Manufacturer getManufactury() {
        return manufactury;
    }

    public List<Integer> getPlz_api() {
        return plz_api;
    }

    public ManufacturyModel() {
        manufactury = new Manufacturer();
        plz_api = new ArrayList<>();
        plz_api.add(48477);
        plz_api.add(48499);
        plz_api.add(50000);  
    }
    
    @PostConstruct
    public void init(){
        manufacturer = new ArrayList<>();
        manufacturer.addAll(Manufacturers.getAll());
    }
    
    public void add(){
        try {
            manufacturer.add(Manufacturers.add(manufactury));
            manufactury = new Manufacturer();
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_INFO,"Manufactory add!","Manufactory add!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Manufactory not add!","Manufactory not add!"));
        }
        
    }
    
}
