package io.arrogantprogrammer.thanksgivingai;

import io.arrogantprogrammer.thanksgivingai.api.CreateInvitationCommand;
import io.arrogantprogrammer.thanksgivingai.api.CreateMenuCommand;
import io.arrogantprogrammer.thanksgivingai.api.ThanksgivingInvitation;
import io.arrogantprogrammer.thanksgivingai.api.ThanksgivingMenu;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

import java.net.URI;
import java.util.List;

@ApplicationScoped
public class AiService {

    public ThanksgivingMenu createMenu(CreateMenuCommand createMenuCommand) {
        ThanksgivingMenu thanksgivingMenu = new ThanksgivingMenu(createMenuCommand.email(), mockMains(), mockSides(), mockDesserts());
        Log.debugf("Created %s for %s", thanksgivingMenu, createMenuCommand);
        return thanksgivingMenu;
    }

    private List<String> mockMains() {
        return List.of("Turkey", "Ham", "Tofurkey");
    }

    private List<String> mockSides() {
        return List.of("Mashed Potatoes", "Green Beans", "Cranberry Sauce", "Mac & Cheese", "Sweet Potatoes", "Rolls");
    }

    private List<String> mockDesserts() {
        return List.of("Pumpkin Pie", "Coconut Cake");
    }

    public ThanksgivingInvitation createInvitation(CreateInvitationCommand createInvitationCommand) {
        Log.debugf("Creating invitation for %s", createInvitationCommand.thanksgivingMenu());
        return new ThanksgivingInvitation(URI.create("http://localhost:8080/static/thanksgiving-menu-01.jpg"), createInvitationCommand.thanksgivingMenu());
    }
}
