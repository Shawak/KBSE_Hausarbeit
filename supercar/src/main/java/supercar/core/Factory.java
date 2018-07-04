/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.Produces;

/**
 *
 * @author Maxi
 */
public class Factory {
    
    @Produces
    public PlzApi createPlzApi() {
        return new PlzApi();
    }
    
    @Produces
    public Gson createGson() {
        return new GsonBuilder().setPrettyPrinting().create();
    }
    
}
