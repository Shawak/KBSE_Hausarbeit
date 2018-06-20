/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.core;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Singleton;
import supercar.entities.*;
import supercar.enums.AccountType;
import supercar.interfaces.IRepositoryAccessor;

/**
 *
 * @author Maxi
 */
@Startup
@Singleton
public class StartupBean extends IRepositoryAccessor {
    
    @PostConstruct
    void init() {
        if (Accounts.getAll().isEmpty()) {
            Accounts.add(new Account("Administrator", "Administrator", 0, "", "admin", "admin", "", AccountType.Administrator, true));
            
            Model astra = Models.add(new Model("Astra", 0, 0));
            Model sprinter = Models.add(new Model("Sprinter", 0, 0));
            Model aventador = Models.add(new Model("Aventador", 0, 0));
            Model gtr = Models.add(new Model("GT-R", 0, 0));
            Model kangoo = Models.add(new Model("Kangoo", 0, 0));
            Model caddy = Models.add(new Model("Caddy", 0, 0));
            Model aygo = Models.add(new Model("Aygo", 0, 0));
            Model v70 = Models.add(new Model("V70", 0, 0));
            Model granTurismo = Models.add(new Model("GranTurismo", 0, 0));
            
            Manufacturers.add(new Manufacturer("Opel", 0, "", "")).getModels().add(astra);
            Manufacturers.add(new Manufacturer("Mercedes-Benz", 0, "", "")).getModels().add(sprinter);
            Manufacturers.add(new Manufacturer("Lamborghini", 0, "", "")).getModels().add(aventador);
            Manufacturers.add(new Manufacturer("Nissan", 0, "", "")).getModels().add(gtr);
            Manufacturers.add(new Manufacturer("Renault", 0, "", "")).getModels().add(kangoo);
            Manufacturers.add(new Manufacturer("VW", 0, "", "")).getModels().add(caddy);
            Manufacturers.add(new Manufacturer("Toyota", 0, "", "")).getModels().add(aygo);
            Manufacturers.add(new Manufacturer("Volvo", 0, "", "")).getModels().add(v70);
            Manufacturers.add(new Manufacturer("Maserati", 0, "", "")).getModels().add(granTurismo);
            
            Cars.add(new Car("OS HS 0001", 40.0f, astra));
            Cars.add(new Car("OS HS 0002", 50.0f, sprinter));
            Cars.add(new Car("OS HS 0003", 120.0f, aventador));
            Cars.add(new Car("OS HS 0004", 31.0f, gtr));
            Cars.add(new Car("OS HS 0005", 60.5f, kangoo));
            Cars.add(new Car("OS HS 0006", 42.75f, caddy));
            Cars.add(new Car("OS HS 0007", 75.31f, aygo));
            Cars.add(new Car("OS HS 0008", 65.7f, v70));
            Cars.add(new Car("OS HS 0009", 21.5f, granTurismo));
        }
    }
    
}