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
import supercar.entities.*;
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
            
            Model astra = DB.Models.add(new Model("Astra", 0, 0));
            Model sprinter = DB.Models.add(new Model("Sprinter", 0, 0));
            Model aventador = DB.Models.add(new Model("Aventador", 0, 0));
            Model gtr = DB.Models.add(new Model("GT-R", 0, 0));
            Model kangoo = DB.Models.add(new Model("Kangoo", 0, 0));
            Model caddy = DB.Models.add(new Model("Caddy", 0, 0));
            Model aygo = DB.Models.add(new Model("Aygo", 0, 0));
            Model v70 = DB.Models.add(new Model("V70", 0, 0));
            Model granTurismo = DB.Models.add(new Model("GranTurismo", 0, 0));
            
            DB.Manufacturers.add(new Manufacturer("Opel", 0, "", "")).getModels().add(astra);
            DB.Manufacturers.add(new Manufacturer("Mercedes-Benz", 0, "", "")).getModels().add(sprinter);
            DB.Manufacturers.add(new Manufacturer("Lamborghini", 0, "", "")).getModels().add(aventador);
            DB.Manufacturers.add(new Manufacturer("Nissan", 0, "", "")).getModels().add(gtr);
            DB.Manufacturers.add(new Manufacturer("Renault", 0, "", "")).getModels().add(kangoo);
            DB.Manufacturers.add(new Manufacturer("VW", 0, "", "")).getModels().add(caddy);
            DB.Manufacturers.add(new Manufacturer("Toyota", 0, "", "")).getModels().add(aygo);
            DB.Manufacturers.add(new Manufacturer("Volvo", 0, "", "")).getModels().add(v70);
            DB.Manufacturers.add(new Manufacturer("Maserati", 0, "", "")).getModels().add(granTurismo);
            
            DB.Cars.add(new Car("OS HS 0001", 40.0f, astra));
            DB.Cars.add(new Car("OS HS 0002", 50.0f, sprinter));
            DB.Cars.add(new Car("OS HS 0003", 120.0f, aventador));
            DB.Cars.add(new Car("OS HS 0004", 31.0f, gtr));
            DB.Cars.add(new Car("OS HS 0005", 60.5f, kangoo));
            DB.Cars.add(new Car("OS HS 0006", 42.75f, caddy));
            DB.Cars.add(new Car("OS HS 0007", 75.31f, aygo));
            DB.Cars.add(new Car("OS HS 0008", 65.7f, v70));
            DB.Cars.add(new Car("OS HS 0009", 21.5f, granTurismo));
        }
    }
    
}
