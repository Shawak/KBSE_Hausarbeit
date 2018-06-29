/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import supercar.core.LoginHandler;
import supercar.interfaces.IModel;

/**
 *
 * @author Patrick
 */
@Named("menu")
@SessionScoped
public class MenuModel extends IModel{
    
    public MenuModel(){
        
    }
    
    @PostConstruct
    public void init(){
    
    }

    public LoginHandler getLoginHandler() {
        return LoginHandler;
    }
    
    public boolean isLoggedIn(){
        System.out.println("aaa");
        return LoginHandler.isLoggedIn();
    }
    
}
