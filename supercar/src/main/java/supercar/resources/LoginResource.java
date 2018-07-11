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
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import supercar.abstracts.IResource;

/**
 *
 * @author Maxi
 */
@RequestScoped
@Path("login")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class LoginResource extends IResource {

    @GET
    public Response isLoggedIn() {
        return Ok(LoginHandler.isLoggedIn());
    }

    @POST
    public Response login(@QueryParam("login") String login, @QueryParam("password") String password) {
        return Ok(LoginHandler.login(login, password));
    }

    @GET
    @Path("logout")
    public Response logout() {
        LoginHandler.logout();
        return Ok("logged out");
    }

}
