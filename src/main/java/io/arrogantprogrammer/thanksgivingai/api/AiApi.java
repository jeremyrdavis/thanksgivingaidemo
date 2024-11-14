package io.arrogantprogrammer.thanksgivingai.api;

import io.quarkus.logging.Log;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.ArrayList;

@Path("/ai")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AiApi {

    @GET
    @Path("/menu")
    public Response createMenu() {
        ThanksgivingMenu thanksgivingMenu = new ThanksgivingMenu("jeremy.davis@redhat.com", new ArrayList<String>(){{
            add("Brined and Roasted Turkey");
            add("Ham");
        }}, new ArrayList<String>(){{
            add("Mashed Potatoes");
            add("Green Bean Casserole");
            add("Mac and Cheese");
            add("Dinner Rolls");
        }}, new ArrayList<String>(){{
            add("Pumpkin Pie");
            add("Apple Pie");
            add("Pecan Pie");
        }});
        return Response.ok(thanksgivingMenu).build();
    }

}
