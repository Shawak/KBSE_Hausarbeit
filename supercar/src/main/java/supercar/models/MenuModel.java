/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import supercar.interfaces.IModel;

/**
 *
 * @author Patrick
 */
@Named("menu")
@RequestScoped
public class MenuModel extends IModel {

    public MenuModel() {

    }

    @PostConstruct
    public void init() {

    }
    
    public void logout(){
        System.out.println("logout");
        LoginHandler.logout();
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        try {
            context.redirect(context.getRequestContextPath()+"/");
        } catch (IOException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
