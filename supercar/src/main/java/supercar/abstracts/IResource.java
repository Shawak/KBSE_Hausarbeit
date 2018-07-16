/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.abstracts;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Serializable;
import javax.ws.rs.core.Response;

/**
 *
 * @author Maximilian Nussbaum
 */
public abstract class IResource extends IRestrictableRepositoryAccessor implements Serializable {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    protected Response Ok() {
        return Response.ok().build();
    }

    protected Response Ok(Object obj) {
        return Response.ok(gson.toJson(obj)).build();
    }

    protected Response Forbidden() {
        return Response.status(Response.Status.FORBIDDEN).build();
    }

    protected Response BadRequest() {
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
