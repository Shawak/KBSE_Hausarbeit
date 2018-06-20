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
import supercar.entities.Car;
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
            
            DB.Cars.add(new Car("OS HS 0001", 40.0f));
            DB.Cars.add(new Car("OS HS 0002", 50.0f));
            DB.Cars.add(new Car("OS HS 0003", 45.0f));
            DB.Cars.add(new Car("OS HS 0004", 31.0f));
            DB.Cars.add(new Car("OS HS 0005", 60.5f));
            DB.Cars.add(new Car("OS HS 0006", 42.75f));
            DB.Cars.add(new Car("OS HS 0007", 75.31f));
            DB.Cars.add(new Car("OS HS 0008", 65.7f));
            DB.Cars.add(new Car("OS HS 0009", 21.5f));
        }
    }
    
}
