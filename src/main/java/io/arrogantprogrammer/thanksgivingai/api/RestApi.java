package io.arrogantprogrammer.thanksgivingai.api;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.InputStream;

@Path("/thanksgivingai")
public class RestApi {

    @POST
    @Path("/menu")
    public Response createMenu() {
        InputStream imageStream = getClass().getClassLoader().getResourceAsStream("thanksgiving-menu-01.png");
        if (imageStream == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(imageStream).type("image/png").build();
    }

    @GET
    @Path("/menu")
    public Response getMenu() {
        InputStream imageStream = getClass().getClassLoader().getResourceAsStream("thanksgiving-menu-01.png");
        if (imageStream == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(imageStream).type("image/png").build();
    }
}
