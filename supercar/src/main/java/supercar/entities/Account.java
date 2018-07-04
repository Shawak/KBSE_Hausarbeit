/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import supercar.enums.AccountType;
import supercar.interfaces.IUniqueEntity;
import supercar.validator.PLZ;

/**
 *
 * @author Maxi
 */
@Entity
public class Account extends IUniqueEntity {

    @NotNull(message = "Firstname may not be empty")
    private String firstname;
    @NotNull(message = "Lastname may not be empty")
    private String lastname;
    
    @PLZ
    private Integer plz;
    @NotNull(message = "Street may not be empty")
    private String street;
    private String city;
    
    @NotNull(message = "Username may not be empty")
    private String login;
    @NotNull(message = "Password may not be empty")
    private String password;
    
    private String licenseNumber; 
    
    private int accountType;
    private boolean activated;
    private boolean banned;

    
    
    @OneToMany
    @JoinColumn(name="Account_ID")
    private List<Lending> lendings;

    public List<Lending> getLendings() {
        return lendings == null ? new ArrayList<>() : lendings;
    }

    public void setLendings(List<Lending> lendings) {
        this.lendings = lendings;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getPlz() {
        return plz;
    }

    public void setPlz(Integer plz) {
        this.plz = plz;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public String getLicenseNumber() {
        return licenseNumber;
    }
    
    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
    
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType.getValue();
    }
    
    public AccountType getAccountType() {
        return AccountType.fromInt(this.accountType);
    }
    
    public boolean isAtleast(AccountType accountType) {
        return this.accountType >= accountType.getValue();
    }
    
    public boolean isEmployee() {
        return accountType >= AccountType.Employee.getValue();
    }
    
    public boolean isAdministrator() {
          return accountType >= AccountType.Administrator.getValue();
    }
    
    public void addLending(Lending lending){
        this.lendings.add(lending);
    }
    
    public Account() { }
    
    public Account(String firstname, String lastname, Integer plz, String street, String login, String password, String licenseNumber, AccountType accountType, boolean activated, String city) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.plz = plz;
        this.street = street;
        this.login = login;
        this.password = password;
        this.licenseNumber = licenseNumber;
        this.accountType = accountType.getValue();
        this.activated = activated;
        this.city = city;
    }
    
}