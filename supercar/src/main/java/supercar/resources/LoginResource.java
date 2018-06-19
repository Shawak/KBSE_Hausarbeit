/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.resources;

import com.google.gson.Gson;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import supercar.core.LoginHandler;

/**
 *
 * @author Maxi
 */
@RequestScoped
@Path("login")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class LoginResource implements Serializable {
    
    @Inject
    private LoginHandler loginHandler;
    
    private Gson gson = new Gson();
    
    @GET
    public Response test() {
        boolean loggedIn = loginHandler.isLoggedIn();
        return Response.ok(gson.toJson(loggedIn)).build();
    }
    
    @GET @Path("{login}/{password}")
    public Response login2(@PathParam("login") String login, @PathParam("password") String password) {
        boolean success = loginHandler.login(login, password);
        return Response.ok(gson.toJson(success)).build();
    }
    
    @POST
    public Response login(@QueryParam("login") String login, @QueryParam("password") String password) {
        boolean success = loginHandler.login(login, password);
        return Response.ok(gson.toJson(success)).build();
    }
    
}