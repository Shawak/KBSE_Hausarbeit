/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.interfaces;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Serializable;
import javax.inject.Inject;
import supercar.core.LoginHandler;

/**
 *
 * @author Maxi
 */
public abstract class IResource extends IRepositoryAccessor implements Serializable {
    
    @Inject
    protected LoginHandler loginHandler;
    
    protected Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
}
