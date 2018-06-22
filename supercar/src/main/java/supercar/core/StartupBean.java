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
        for (AccountType c : AccountType.values()) {
            System.out.println(c);
        }
        
        System.out.println(AccountType.fromInt(AccountType.Administrator.getValue()));
        
        if (Accounts.getAll().isEmpty()) {
            Accounts.add(new Account("Administrator", "Administrator", 0, "", "admin", "admin", "", AccountType.Administrator));
            
            Manufacturer opel = Manufacturers.add(new Manufacturer("Opel", 65423, "Bahnhofsplatz", ""));
            Manufacturer mercedes = Manufacturers.add(new Manufacturer("Mercedes-Benz", 70327, "Mercedesstraße 137", ""));
            Manufacturer lamborghini = Manufacturers.add(new Manufacturer("Lamborghini", 40476, "Rather Strasse 78-80", ""));
            Manufacturer nissan = Manufacturers.add(new Manufacturer("Nissan", 50321, "Renault-Nissan-Straße 6-10", ""));
            Manufacturer renault = Manufacturers.add(new Manufacturer("Renault", 50321, "Renault-Nissan-Straße 6-10", ""));
            Manufacturer vw = Manufacturers.add(new Manufacturer("VW", 38440, "Berliner Ring 2", ""));
            Manufacturer toyota = Manufacturers.add(new Manufacturer("Toyota", 50858, "Toyota-Allee 2 ", ""));
            Manufacturer volvo = Manufacturers.add(new Manufacturer("Volvo", 50679, "Siegburger Straße 229", ""));
            Manufacturer maserati = Manufacturers.add(new Manufacturer("Maserati", 65201, "Stielstraße 3b", ""));
            
            Model astra = Models.add(new Model("Astra", opel, 0, 0));
            Model sprinter = Models.add(new Model("Sprinter", mercedes, 0, 0));
            Model aventador = Models.add(new Model("Aventador", lamborghini, 0, 0));
            Model gtr = Models.add(new Model("GT-R", nissan, 0, 0));
            Model kangoo = Models.add(new Model("Kangoo", renault, 0, 0));
            Model caddy = Models.add(new Model("Caddy", vw, 0, 0));
            Model aygo = Models.add(new Model("Aygo", toyota, 0, 0));
            Model v70 = Models.add(new Model("V70", volvo, 0, 0));
            Model granTurismo = Models.add(new Model("GranTurismo", maserati, 0, 0));
            
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