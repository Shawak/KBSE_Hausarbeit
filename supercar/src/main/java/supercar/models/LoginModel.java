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
import supercar.core.PlzApi;
import supercar.entities.Account;
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

    private String password2;

    private Account account;

    private String city;

    private PlzApi plzApi;

    public LoginModel() {
        account = new Account();
        plzApi = new PlzApi();
    }

    @PostConstruct
    public void init() {
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

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getCity() {
        if (account.getPlz() == null) {
            city = "";
            return city;
        } else {
            city = plzApi.getName(account.getPlz());
            if (city == null) {
                city = "";
                return city;
            }
            city = city.substring(0, city.length() - 1).substring(1);
            return city;
        }
    }

    public String login() {
        if (LoginHandler.login(login, password)) {
            return "index.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username or Password wrong", "Username or Password wrong"));
            return null;
        }
    }

    public void register() {

        if (Accounts.getByLogin(account.getLogin()) != null) {
            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username already in use!", "Username already in use!"));
        } else if (!account.getPassword().equals(password2)) {
            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "\"Password\" and \"Password confirmation\" do not match!", "\"Password\" and \"Password confirmation\" do not match!"));
        } else {
        }
    }
}
