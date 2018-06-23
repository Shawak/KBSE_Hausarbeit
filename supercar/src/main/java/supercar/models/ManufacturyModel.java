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
import org.primefaces.PrimeFaces;
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
    
    //stream macht eine Kopie und keine Referenz
    public void change(Long id){
        change_manufactury=manufacturer.stream().filter(manufactory->manufactory.getId().equals(id)).findFirst().get();
        System.out.println(change_manufactury.getVersion()+"aaaa");
    }
    
    public void change(){
        change_manufactury = Manufacturers.update(change_manufactury);
        System.out.println(change_manufactury.getVersion());
        manufacturer.clear();
        manufacturer.addAll(Manufacturers.getAll());
    }
}
