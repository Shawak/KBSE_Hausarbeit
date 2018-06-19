/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.core;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.ejb.Singleton;
import supercar.entities.Account;
import supercar.enums.AccountType;
import supercar.repositories.DB;

/**
 *
 * @author Maxi
 */
@Startup
@Singleton
public class StartupBean {
    
    @Inject
    DB DB;
    
    @PostConstruct
    void init() {
        if (DB.Accounts.getAll().isEmpty()) {
            DB.Accounts.add(new Account("Administrator", "Administrator", 0, "", "admin", "admin", "", AccountType.Administrator, true));
        }
    }
    
}
