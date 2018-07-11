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
import supercar.enums.AccountType;
import supercar.abstracts.IResource;

/**
 *
 * @author Maxi Optional Jax-RS Parameter (Probably don't include this cuz it's
 * not worth the effort):
 * https://stackoverflow.com/questions/32765804/optional-params-in-rest-api-request-using-jersey-2-21/32778643#32778643
 */
@RequestScoped
@Path("cars")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class CarsResource extends IResource {

    @GET
    public Response get() {
        return Ok(Cars.getAll());
    }

    @GET
    @Path("free/{order}/{sort}")
    public Response getFree(@PathParam("order") String order, @PathParam("sort") String sort) {
        if (!LoginHandler.hasAccess(AccountType.User)) {
            return Forbidden();
        }

        return Ok(Cars.getAllFree(order, sort));
    }

    @GET
    @Path("repairs/{order}/{sort}")
    public Response getRepairs(@PathParam("order") String order, @PathParam("sort") String sort) {
        if (!LoginHandler.hasAccess(AccountType.User)) {
            return Forbidden();
        }

        return Ok(Cars.getCarAtRepair(order, sort));
    }

    @GET
    @Path("lendings/{order}/{sort}")
    public Response getLendings(@PathParam("order") String order, @PathParam("sort") String sort) {
        if (!LoginHandler.hasAccess(AccountType.User)) {
            return Forbidden();
        }

        return Ok(Cars.getCarAtLending(order, sort));
    }

}
