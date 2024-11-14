package io.arrogantprogrammer.thanksgivingai;

import io.arrogantprogrammer.thanksgivingai.api.*;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AiService {

    public ThanksgivingMenu createMenu(CreateMenuCommand createMenuCommand) {
        ThanksgivingMenu thanksgivingMenu = new ThanksgivingMenu(createMenuCommand.email(), mockMains(), mockSides(), mockDesserts());
        Log.debugf("Created %s for %s", thanksgivingMenu, createMenuCommand);
        return thanksgivingMenu;
    }

    private List<ThanksgivingMenuItem> mockMains() {
        return new ArrayList<>(){{
            add(new ThanksgivingMenuItem("Turkey", "Roasted"));
            add(new ThanksgivingMenuItem( "Ham", "Honey Baked"));
            add(new ThanksgivingMenuItem("Tofurkey", "Vegan"));
        }};
    }

    private List<ThanksgivingMenuItem> mockSides() {
        return new ArrayList<>(){{
            add(new ThanksgivingMenuItem("Mashed Potatoes", "Creamy"));
            add(new ThanksgivingMenuItem("Green Beans", "Almondine"));
            add(new ThanksgivingMenuItem("Cranberry Sauce", "Homemade"));
            add(new ThanksgivingMenuItem("Mac & Cheese", "Baked"));
            add(new ThanksgivingMenuItem("Sweet Potatoes", "Candied"));
            add(new ThanksgivingMenuItem("Rolls", "Buttery"));
        }};
    }

    private List<ThanksgivingMenuItem> mockDesserts() {
        return new ArrayList<>(){{
            add(new ThanksgivingMenuItem("Pumpkin Pie", "Traditional"));
            add(new ThanksgivingMenuItem("Coconut Cake", "Layered"));
        }};
    }

    public ThanksgivingInvitation createInvitation(CreateInvitationCommand createInvitationCommand) {
        Log.debugf("Creating invitation for %s", createInvitationCommand.thanksgivingMenu());
        return new ThanksgivingInvitation(URI.create("http://localhost:8080/static/thanksgiving-menu-01.jpg"), createInvitationCommand.thanksgivingMenu());
    }
}
