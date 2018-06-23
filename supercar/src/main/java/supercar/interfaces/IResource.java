/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.interfaces;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Serializable;
import javax.ws.rs.core.Response;

/**
 *
 * @author Maxi
 */
public abstract class IResource extends IRestrictableRepositoryAccessor implements Serializable {
   
    protected Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    protected Response Ok(Object obj) {
        return Response.ok(gson.toJson(obj)).build();
    }
    
    protected Response Forbidden() {
        return Response.status(Response.Status.FORBIDDEN).build();
    }
     
}