/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import supercar.entities.Account;
import supercar.enums.AccountType;
import supercar.repositories.DB;

/**
 *
 * @author Maxi
 */
@Named("indexModel")
public class IndexModel {

    @Inject
    private DB DB;
    
    private String test = "Hello!";
   
    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public IndexModel() { }

    @PostConstruct
    public void init() {
        if (DB.Accounts.getAll().isEmpty()) {
            DB.Accounts.add(new Account("I am the", "admin", 0, "", "admin", "admin", "", AccountType.Administrator));
        }
    }

}
