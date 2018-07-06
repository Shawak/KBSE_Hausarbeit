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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import supercar.entities.Lending;
import supercar.interfaces.IModel;

/**
 *
 * @author Patrick
 */
@Named("return")
@SessionScoped
public class ReturnModel extends IModel {

    private Collection<Lending> lendings;
    Lending returnlending;
    private boolean close;

    public ReturnModel() {

    }

    @PostConstruct
    public void init() {
        lendings = LoginHandler.getAccount().getLendings().stream().filter((Lending l) -> l.getReturnDate() == null).collect(Collectors.toList());
    }

    public Collection<Lending> getLendings() {
        return lendings;
    }

    public void setLendings(Collection<Lending> lendings) {
        this.lendings = lendings;
    }

    public Lending getReturnlending() {
        return returnlending;
    }

    public void setReturnlending(Lending returnlending) {
        this.returnlending = returnlending;
    }
    
    
    
    public void returnCar(long id){
        returnlending = Lendings.get(id);
        
        Calendar c = new GregorianCalendar();
        c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        
        returnlending.setReturnDate(c.getTimeInMillis());
    }
    
    public void returnCar(){
        Lending tmp = Lendings.getLastLendingByCarId(returnlending.getCar().getId());
        if(tmp == null){
            if(returnlending.getRentMileage() == null || returnlending.getRentMileage()<0){
                FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Rent Mileage must be greather than 0!", "Rent Mileage must be greather than 0!"));
            }
            else if(returnlending.getReturnMileage() == null || returnlending.getReturnMileage()<returnlending.getRentMileage()){
                FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Return Mileage must be greather than Rent Mileage!", "Return Mileage must be greather than Rent Mileage!"));
            }
            else{
                Lendings.update(returnlending);
                lendings = LoginHandler.getAccount().getLendings().stream().filter((Lending l) -> l.getReturnDate() == null).collect(Collectors.toList());
                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                try {
                    context.redirect(context.getRequestContextPath()+"/faces/return.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        else{
            if(returnlending.getRentMileage() == null || returnlending.getRentMileage()<tmp.getReturnMileage()){
                FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Rent Mileage must be greather than "+tmp.getReturnMileage()+"!", "Rent Mileage must be greather than "+tmp.getReturnMileage()+"!"));
            }
            else if(returnlending.getReturnMileage() == null || returnlending.getReturnMileage()<returnlending.getRentMileage()){
                FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Return Mileage must be greather than Rent Mileage!", "Return Mileage must be greather than Rent Mileage!"));
            }
            else{
                Lendings.update(returnlending);
                lendings = LoginHandler.getAccount().getLendings().stream().filter((Lending l) -> l.getReturnDate() == null).collect(Collectors.toList());
                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
                try {
                    context.redirect(context.getRequestContextPath()+"/faces/return.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public boolean isClose() {
        return close;
    }
    
}
