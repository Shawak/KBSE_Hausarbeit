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
import javax.validation.constraints.NotNull;
import supercar.entities.Account;
import supercar.enums.AccountType;
import supercar.abstracts.IModel;

/**
 *
 * @author Patrick Wiethoff
 */
@Named("profile")
@SessionScoped
public class ProfileModel extends IModel {

    private Account account;

    private String city;

    @NotNull(message = "licenseNumber may not be empty")
    private String licenseNumber;

    private String password2;

    public ProfileModel() {

    }

    @PostConstruct
    public void init() {
        account = LoginHandler.getAccount();
        licenseNumber = account.getLicenseNumber();
    }

    public Account getAccount() {
        account = LoginHandler.getAccount();
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

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
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

    public void save() {
        if (!account.getPassword().equals(password2)) {
            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "\"Password\" and \"Password confirmation\" do not match!", "\"Password\" and \"Password confirmation\" do not match!"));
        } else if (PlzApi.getName(account.getPlz()).isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Wrong Post Code!", "Wrong Post Code!"));
        } else {
            try {
                account.setCity(city);
                account.setLicenseNumber(licenseNumber);
                account.setAccountType(AccountType.User);
                account.setActivated(true);

                account = Accounts.update(account);
                FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_INFO, "Account change!", "Account change!"));
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage("form:result2", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Account not change!", "Account not change!"));
            }
        }
    }
}
