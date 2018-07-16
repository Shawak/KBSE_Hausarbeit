/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.resources;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import supercar.core.PlzApi;
import supercar.abstracts.IResource;

/**
 *
 * @author Maximilian Nussbaum
 */
@RequestScoped
@Path("plz")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class PlzResource extends IResource {

    @Inject
    PlzApi PlzApi;

    @GET
    @Path("{plz}")
    public Response get(@PathParam("plz") int plz) {
        try {
            return Ok(PlzApi.getName(plz));
        } catch (Exception ex) {
            Logger.getLogger(PlzResource.class.getName()).log(Level.SEVERE, null, ex);
            return Ok("Post Code Error");
        }
    }

}
