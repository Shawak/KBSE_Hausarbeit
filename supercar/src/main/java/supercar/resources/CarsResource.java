/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.resources;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import supercar.enums.AccountType;
import supercar.interfaces.IResource;

/**
 *
 * @author Maxi
 */
@RequestScoped
@Path("cars")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class CarsResource extends IResource {
    
    @GET
    public Response get() {
        if (!LoginHandler.hasAccess(AccountType.User)) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
        
        return Response.ok(gson.toJson(Cars.getAll())).build();
    }

}