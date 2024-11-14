package io.arrogantprogrammer.thanksgivingai.api;

import io.quarkus.logging.Log;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.InputStream;
import java.net.URI;

@Path("/ai")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestApi {

    @GET
    @Path("/hello")
    public Response hello() {
        return Response.ok("Hello from Thanksgiving AI!").build();
    }

    @POST
    @Path("/invitation")
    public Response createInvitation(CreateInvitationCommand createInvitationCommand) {
        Log.debugf("Creating invitation for %s", createInvitationCommand.thanksgivingMenu());
        ThanksgivingInvitation thanksgivingInvitation = new ThanksgivingInvitation(
                URI.create("http://localhost:8080/static/thanksgiving-menu-01.png"), createInvitationCommand.thanksgivingMenu());
        return Response.ok(thanksgivingInvitation).build();
    }

    @POST
    @Path("/menu")
    public Response createMenu(CreateMenuCommand createMenuCommand) {
        return Response.ok("Hi").build();
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
