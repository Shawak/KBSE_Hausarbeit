/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import supercar.entities.Manufacturer;

/**
 *
 * @author Patrick
 */
@Named("manufactury")
public class ManufacturyModel {
    
    private List<Integer> plz;
    private Manufacturer manufactury;

    public Manufacturer getManufactury() {
        return manufactury;
    }

    public List<Integer> getPlz() {
        return plz;
    }

    public ManufacturyModel() {
        manufactury = new Manufacturer();
        plz = new ArrayList<>();
        plz.add(48477);
        plz.add(48499);
        plz.add(50000);
        
    }
    
    
    
    
    
}
