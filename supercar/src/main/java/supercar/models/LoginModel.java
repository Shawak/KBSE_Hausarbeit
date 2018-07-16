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
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import supercar.entities.Account;
import supercar.enums.AccountType;
import supercar.abstracts.IModel;

/**
 *
 * @author Patrick Wiethoff
 */
@Named("login")
@SessionScoped
public class LoginModel extends IModel {

    private String login;
    private String password;

    private String password2;

    private Account account;

    private String city;

    @NotNull(message = "licenseNumber may not be empty")
    private String licenseNumber;

    public LoginModel() {
        account = new Account();
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

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getCity() {
        if (account.getPlz() == null) {
            city = "";
            return city;
        } else {
            city = PlzApi.getName(account.getPlz());
            return city;
        }
    }

    public void login() {
        if (LoginHandler.login(login, password)) {
            login = "";
            password = "";

            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            try {
                context.redirect(context.getRequestContextPath() + "/");
            } catch (IOException ex) {
                Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            }
            //return "index.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage("form:result", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username or Password wrong", "Username or Password wrong"));
            //return null;
        }
    }

    public void register() {

        if (Accounts.getByLogin(account.getLogin()) != null) {
            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username already in use!", "Username already in use!"));
        } else if (!account.getPassword().equals(password2)) {
            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "\"Password\" and \"Password confirmation\" do not match!", "\"Password\" and \"Password confirmation\" do not match!"));
        } else if (PlzApi.getName(account.getPlz()).isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong Post Code!", "Wrong Post Code!"));
        } else {
            try {
                account.setCity(city);
                account.setLicenseNumber(licenseNumber);
                account.setAccountType(AccountType.User);
                account.setActivated(false);

                account = Accounts.add(account);
                FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_INFO, "Account add!", "Account add!"));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Account not add!", "Account not add!"));

            }
        }
    }
}
