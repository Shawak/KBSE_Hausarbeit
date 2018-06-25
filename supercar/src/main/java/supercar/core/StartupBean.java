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
            Accounts.add(new Account("Administrator", "Administrator", 0, "", "admin", "admin", "", AccountType.Administrator));
            Accounts.add(new Account("Max", "Mustermann", 0, "", "user", "user", "", AccountType.User));
            
            Manufacturer opel = Manufacturers.add(new Manufacturer("Opel", 65428, "Bahnhofsplatz", "", "Rüsselheim"));
            Manufacturer mercedes = Manufacturers.add(new Manufacturer("Mercedes-Benz", 70327, "Mercedesstraße 137", "", "Stuttgart Rotenberg"));
            Manufacturer lamborghini = Manufacturers.add(new Manufacturer("Lamborghini", 40476, "Rather Strasse 78-80", "", "Düsseldorf"));
            Manufacturer nissan = Manufacturers.add(new Manufacturer("Nissan", 50321, "Renault-Nissan-Straße 6-10", "", "Brühl"));
            Manufacturer renault = Manufacturers.add(new Manufacturer("Renault", 50321, "Renault-Nissan-Straße 6-10", "", "Brühl"));
            Manufacturer vw = Manufacturers.add(new Manufacturer("VW", 38440, "Berliner Ring 2", "", "Wolfgsburg"));
            Manufacturer toyota = Manufacturers.add(new Manufacturer("Toyota", 50858, "Toyota-Allee 2 ", "", "Köln"));
            Manufacturer volvo = Manufacturers.add(new Manufacturer("Volvo", 50679, "Siegburger Straße 229", "", "Köln"));
            Manufacturer maserati = Manufacturers.add(new Manufacturer("Maserati", 65201, "Stielstraße 3b", "", "Wiesbaden"));
            
            Model astra = Models.add(new Model("Astra", opel, 1, 1));
            Model sprinter = Models.add(new Model("Sprinter", mercedes, 1, 1));
            Model aventador = Models.add(new Model("Aventador", lamborghini, 1, 1));
            Model gtr = Models.add(new Model("GT-R", nissan, 1, 1));
            Model kangoo = Models.add(new Model("Kangoo", renault, 1, 1));
            Model caddy = Models.add(new Model("Caddy", vw, 1, 1));
            Model aygo = Models.add(new Model("Aygo", toyota, 1, 1));
            Model v70 = Models.add(new Model("V70", volvo, 1, 1));
            Model granTurismo = Models.add(new Model("GranTurismo", maserati, 1, 1));
            
            Cars.add(new Car("OS HS 0001", 40.0f, astra, "", ""));
            Cars.add(new Car("OS HS 0002", 50.0f, sprinter, "", ""));
            Cars.add(new Car("OS HS 0003", 120.0f, aventador, "", ""));
            Cars.add(new Car("OS HS 0004", 31.0f, gtr, "", ""));
            Cars.add(new Car("OS HS 0005", 60.5f, kangoo, "", ""));
            Cars.add(new Car("OS HS 0006", 42.75f, caddy, "", ""));
            Cars.add(new Car("OS HS 0007", 75.31f, aygo, "", ""));
            Cars.add(new Car("OS HS 0008", 65.7f, v70, "", ""));
            Cars.add(new Car("OS HS 0009", 21.5f, granTurismo, "", ""));
        }
    }
    
}
