/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.resources;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import supercar.core.PlzApi;
import supercar.interfaces.IResource;

/**
 *
 * @author Maxi
 */
@RequestScoped
@Path("plz")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class PlzResource extends IResource {
    
    PlzApi plzApi = new PlzApi();
    
    @GET @Path("{plz}")
    public Response get(@PathParam("plz") int plz) {
        return Response.ok(gson.toJson(plzApi.getName(plz))).build();
    }
    
}