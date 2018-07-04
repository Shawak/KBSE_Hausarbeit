/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.interfaces;

import com.google.gson.Gson;
import java.io.Serializable;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 *
 * @author Maxi
 */
public abstract class IResource extends IRestrictableRepositoryAccessor implements Serializable {
   
    @Inject
    protected Gson gson;
    
    protected Response Ok(Object obj) {
        return Response.ok(gson.toJson(obj)).build();
    }
    
    protected Response Forbidden() {
        return Response.status(Response.Status.FORBIDDEN).build();
    }
     
}