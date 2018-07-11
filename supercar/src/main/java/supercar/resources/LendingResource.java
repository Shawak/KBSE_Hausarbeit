/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.resources;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import supercar.abstracts.IResource;
import supercar.entities.Car;
import supercar.entities.Lending;

/**
 *
 * @author Maxi Optional Jax-RS Parameter (Probably don't include this cuz it's
 * not worth the effort):
 */
@RequestScoped
@Path("lendings")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class LendingResource extends IResource {

    @GET
    @Path("rent/{id}")
    public Response rent(@PathParam("id") Long id) {
        Car car = Cars.get(id);
        if (car == null) {
            return BadRequest();
        }

        if (Lendings.getLendingByCarId(id) != null) {
            return BadRequest();
        }

        Calendar c = new GregorianCalendar();

        Lending lending = new Lending();
        lending.setCar(car);
        lending.setRentDate(c.getTimeInMillis());

        LoginHandler.getAccount().addLending(lending);
        Lendings.add(lending);

        Accounts.update(LoginHandler.getAccount());
        return Ok();
    }

}
