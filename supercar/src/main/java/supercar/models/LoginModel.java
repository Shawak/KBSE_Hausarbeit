/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import supercar.interfaces.IModel;

/**
 *
 * @author Patrick
 */
@Named("login")
@SessionScoped
public class LoginModel extends IModel {

    private String login;
    private String password;

    public LoginModel() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        if (LoginHandler.login(login, password)) {
            return "index.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username or Password wrong", "Username or Password wrong"));
            return null;
        }
    }

}
