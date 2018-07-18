/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.resources;

import java.util.GregorianCalendar;
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
import supercar.abstracts.IResource;
import supercar.entities.Car;
import supercar.entities.Lending;
import supercar.enums.AccountType;

/**
 *
 * @author Maximilian Nussbaum
 */
@RequestScoped
@Path("lendings")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class LendingResource extends IResource {

    @GET
    public Response get() {
        if (!LoginHandler.hasAccess(AccountType.User)) {
            return Forbidden();
        }

        return Ok(LoginHandler.getAccount().getLendings());
    }

    @GET
    @Path("rent/{id}")
    public Response rent(@PathParam("id") long id) {
        if (!LoginHandler.hasAccess(AccountType.User)) {
            return Forbidden();
        }

        Car car = Cars.get(id);
        if (car == null || Lendings.getLendingByCarId(id) != null) {
            return Error("car does not exist or is currently in a lending");
        }

        Lending lending = new Lending();
        lending.setCar(car);
        lending.setRentDate(new GregorianCalendar().getTimeInMillis() / 1000);

        LoginHandler.getAccount().addLending(lending);
        Lendings.add(lending);

        Accounts.update(LoginHandler.getAccount());
        return Ok();
    }

    @POST
    @Path("return")
    public Response returnCar(@QueryParam("id") long id, @QueryParam("rentMileage") long rentMileage, @QueryParam("returnMileage") long returnMileage, @QueryParam("returnCommentary") String returnCommentary) {
        if (!LoginHandler.hasAccess(AccountType.User)) {
            return Forbidden();
        }

        Lending lending = Lendings.get(id);
        if (lending == null) {
            return Error("id does not belong to a lending");
        }
        
        if (lending.getReturnDate() != null) {
            return Error("lending is already returned");
        }

        Lending lastLending = Lendings.getLastLendingByCarId(lending.getCar().getId());
        if (rentMileage < 0) {
            return Error("returnMileage must be greater than zero");
        }

        if (lastLending != null && rentMileage < lastLending.getReturnMileage()) {
            return Error("returnMileage must be greater than " + lastLending.getRentMileage());
        }

        if (returnMileage < rentMileage) {
            return Error("returnMileage must be greater than or equal rentMileage");
        }

        lending.setRentMileage(rentMileage);
        lending.setReturnMileage(returnMileage);
        lending.setReturnCommentary(returnCommentary);
        lending.setReturnDate(new GregorianCalendar().getTimeInMillis() / 1000);
        Lendings.update(lending);
        return Ok();
    }
}
