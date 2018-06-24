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
import supercar.entities.Model;
import supercar.interfaces.IModel;

/**
 *
 * @author Patrick
 */
@Named("model")
@SessionScoped
public class ModelModel extends IModel {
    
    private Model new_model;
    
    private Model change_model;
    
    private List<Manufacturer> manufacturers;
    private List<Model> models;

    public List<Model> getModels() {
        return models;
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }
    
     public Model getNew_model() {
        return new_model;
    }

    public Model getChange_model() {
        return change_model;
    }

    public ModelModel() {
        new_model = new Model();  
    }
    
    @PostConstruct
    public void init(){
        manufacturers = new ArrayList<>();
        manufacturers.addAll(Manufacturers.getAll());
        
        models = new ArrayList<>();
        models.addAll(Models.getAll());
        
        change_model=new Model();
        change_model.setManufacturer(new Manufacturer());
    }
    
    public void add(){
        try {
            models.add(Models.add(new_model));
            new_model = new Model();
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_INFO,"Model add!","Model add!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error:Model not add!","Error:Model not add!"));
        }
    }
    
    public void change(Long id){
        change_model=models.stream().filter((Model o) -> o.getId().equals(id)).findFirst().get();
    }
    
    public void change(){
        
        try {
            change_model = Models.update(change_model);        
            models=models.stream().map((Model o) -> Objects.equals(o.getId(), change_model.getId())?change_model:o).collect(toList());
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_INFO,"Model change!","Model change!"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().validationFailed();
            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error:Model not change!","Error:Model not change!"));
        }
    }
}
