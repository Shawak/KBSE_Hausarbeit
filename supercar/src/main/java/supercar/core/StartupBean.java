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
            Accounts.add(new Account("Administrator", "Administrator", 49076, "Albrechtstr. 30", "admin", "admin", "", AccountType.Administrator, true, "Osnabrück"));
           
            Account account = new Account("Max", "Mustermann", 49076, "Albrechtstr. 30", "user", "user", "", AccountType.User, true, "Osnabrück");
            account.setLicenseNumber("Z014AB37X95");
            Accounts.add(account);
            
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
            
            Cars.add(new Car("OS HS 0002", 50.00f, sprinter, "Mercedes-Benz_Sprinter.jpg", "white"));
            Cars.add(new Car("OS HS 0003", 120.00f, aventador, "Lamporghini_Aventador.jpg", "red"));
            Cars.add(new Car("OS HS 0004", 31.00f, gtr, "Nissan_GT-R.jpg", "vibrand red"));
            Cars.add(new Car("OS HS 0005", 60.50f, kangoo, "Renault_Kangoo.jpg", "galaxy-gray"));
            Cars.add(new Car("OS HS 0006", 42.75f, caddy, "VW_Kaddy.jpg", "yellow"));
            Cars.add(new Car("OS HS 0007", 75.31f, aygo, "Toyota_Aygo.jpg", "silver"));
            Cars.add(new Car("OS HS 0008", 65.70f, v70, "Volvo_V70.jpg", "silver"));
            
            Car car = new Car("OS HS 0009", 21.50f, granTurismo, "Maserati_Granturismo.jpg", "black");
            Cars.add(car);
           
            Car car2 = new Car("OS HS 0010", 25.50f, kangoo, "Renault_Kangoo.jpg", "galaxy-gray");
            car2.setDeactivated(true);
            Cars.add(car2);
            
            Car car3 = new Car("OS HS 0001", 40.00f, astra, "Opel_Astra.jpg", "gray");
            Cars.add(car3);
            
            Lending lending = new Lending();
            lending.setCar(car);
            //22.5.18
            lending.setRentDate(1526940000000l);
            
            Lendings.add(lending);
            //ohne diesen Befehl funktioniert der danach nicht
            account = Accounts.update(account);
            account.addLending(lending);
            
            
            Lending lending2 = new Lending(1517184000000l,1517356800000l,10l,200l,"",car3);
            //Lending lending3 = new Lending(1518220800000l,1519084800000l,205l,500l,"",car3);
            Lending lending3 = new Lending(1518220800000l,null,null,null,"",car3);
            Lendings.add(lending2);
            Lendings.add(lending3);
            
            account.addLending(lending2);
            account.addLending(lending3);
            Accounts.update(account);
            
            Garages.add(new Garage("Autowerkstatt Gah", 48431, "Frankenburgstr. 7", "Rheine", "Michael Gah"));
            Garages.add(new Garage("Strecke & Hartmann", 49497, "Ibbenbürener Str. 12", "Mettingen", "Torsten Strecke"));
        }   
    }
    
}
