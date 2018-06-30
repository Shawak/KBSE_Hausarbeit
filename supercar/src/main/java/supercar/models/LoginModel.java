/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import supercar.core.PlzApi;
import supercar.entities.Account;
import supercar.enums.AccountType;
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

    private final PlzApi plzApi;

    @NotNull(message = "licenseNumber may not be empty")
    private String licenseNumber;

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
            try {
                city = plzApi.getName(account.getPlz());
            } catch (Exception ex) {
                city = "";
                Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
                return city;
            }
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
            try {
                account.setCity(city);
                account.setLicenseNumber(licenseNumber);
                account.setAccountType(AccountType.User);
                account.setActivated(true);

                account = Accounts.add(account);
                FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_INFO, "Account add!", "Account add!"));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Account not add!", "Account not add!"));

            }
        }
    }
}
