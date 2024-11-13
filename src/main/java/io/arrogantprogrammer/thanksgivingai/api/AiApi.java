package io.arrogantprogrammer.thanksgivingai.api;

import io.quarkus.logging.Log;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.ArrayList;

@Path("/ai")
public class AiApi {

    @POST
    @Path("/menu")
    public Response createMenu(CreateMenuCommand createMenuCommand) {
        Log.debugf("Creating menu for %s", createMenuCommand.email());
        ThanksgivingMenu thanksgivingMenu = new ThanksgivingMenu(createMenuCommand.email(), new ArrayList<String>(){{
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
