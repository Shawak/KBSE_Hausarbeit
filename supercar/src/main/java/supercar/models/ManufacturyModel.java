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
import supercar.entities.Manufacturer;
import supercar.interfaces.IModel;

/**
 *
 * @author Patrick
 */
@Named("manufactury")
@SessionScoped
public class ManufacturyModel extends IModel {
    
    private Manufacturer new_manufactury;
    
    private Manufacturer change_manufactury;
    
    private List<Manufacturer> manufacturer;

    public List<Manufacturer> getManufacturer() {
        return manufacturer;
    }
    
     public Manufacturer getNew_manufactury() {
        return new_manufactury;
    }

    public Manufacturer getChange_manufactury() {
        return change_manufactury;
    }

    public ManufacturyModel() {
        new_manufactury = new Manufacturer();  
    }
    
    @PostConstruct
    public void init(){
        manufacturer = new ArrayList<>();
        manufacturer.addAll(Manufacturers.getAll());
    }
    
    public void add(){
        try {
            manufacturer.add(Manufacturers.add(new_manufactury));
            new_manufactury = new Manufacturer();
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_INFO,"Manufactory add!","Manufactory add!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error:Manufactory not add!","Error:Manufactory not add!"));
        }
    }
    
    public void change(Long id){
        change_manufactury=manufacturer.stream().filter((Manufacturer o) -> o.getId().equals(id)).findFirst().get();
    }
    
    public void change(){
        try {
            change_manufactury = Manufacturers.update(change_manufactury);        
            manufacturer=manufacturer.stream().map((Manufacturer o) -> Objects.equals(o.getId(), change_manufactury.getId())?change_manufactury:o).collect(toList());
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_INFO,"Manufactory change!","Manufactory change!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error:Manufactory not change!","Error:Manufactory not change!"));
        }
        
    }
}
