/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.stream.Collectors.toList;
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
    
    private List<Manufacturer> manufacturers;
    
    private PlzApi plzApi;

    public List<Manufacturer> getManufacturers() {
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
    public void init(){
        manufacturers = new ArrayList<>();
        manufacturers.addAll(Manufacturers.getAll());
    }
    
    public void add(){
        try {
            manufacturers.add(Manufacturers.add(new_manufacturer));
            new_manufacturer = new Manufacturer();
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_INFO,"Manufactory add!","Manufactory add!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error:Manufactory not add!","Error:Manufactory not add!"));
        }
    }
    
    public void change(Long id){
        change_manufacturer=manufacturers.stream().filter((Manufacturer o) -> o.getId().equals(id)).findFirst().get();
    }
    
    public void change(){
        try {
            change_manufacturer = Manufacturers.update(change_manufacturer);        
            manufacturers=manufacturers.stream().map((Manufacturer o) -> Objects.equals(o.getId(), change_manufacturer.getId())?change_manufacturer:o).collect(toList());
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_INFO,"Manufactory change!","Manufactory change!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error:Manufactory not change!","Error:Manufactory not change!"));
        } 
    }
    
}
