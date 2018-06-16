/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import supercar.entities.Account;
import supercar.enums.AccountType;
import supercar.repositories.DB;

/**
 *
 * @author Maxi
 */
public class IndexModel {

    @Inject
    DB DB;

    public IndexModel() { }

    @PostConstruct
    public void init() {
        if (DB.Accounts.getAll().isEmpty()) {
            DB.Accounts.add(new Account("I am the", "admin", 0, "", "admin", "admin", "", AccountType.Administrator));
        }
    }

}
