package io.arrogantprogrammer.thanksgivingai;

import io.arrogantprogrammer.thanksgivingai.api.*;
import io.arrogantprogrammer.thanksgivingai.domain.ThanksgivingMenu;
import io.arrogantprogrammer.thanksgivingai.rest.ChatGPTService;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AiService {

    @Inject
    ChatGPTService chatGPTService;

    public ThanksgivingMenuRecord createMenu(CreateMenuCommand createMenuCommand) {
        String prompt = ThanksgivingMenu.createPrompt(createMenuCommand.stateCodes());
        ThanksgivingMenuRecord result = chatGPTService.chat(prompt);
        Log.debugf("Created menu %s", result);
        return result;
    }

    private List<ThanksgivingMenuItemRecord> mockMains() {
        return new ArrayList<>(){{
            add(new ThanksgivingMenuItemRecord("Turkey", "Roasted"));
            add(new ThanksgivingMenuItemRecord( "Ham", "Honey Baked"));
            add(new ThanksgivingMenuItemRecord("Tofurkey", "Vegan"));
        }};
    }

    private List<ThanksgivingMenuItemRecord> mockSides() {
        return new ArrayList<>(){{
            add(new ThanksgivingMenuItemRecord("Mashed Potatoes", "Creamy"));
            add(new ThanksgivingMenuItemRecord("Green Beans", "Almondine"));
            add(new ThanksgivingMenuItemRecord("Cranberry Sauce", "Homemade"));
            add(new ThanksgivingMenuItemRecord("Mac & Cheese", "Baked"));
            add(new ThanksgivingMenuItemRecord("Sweet Potatoes", "Candied"));
            add(new ThanksgivingMenuItemRecord("Rolls", "Buttery"));
        }};
    }

    private List<ThanksgivingMenuItemRecord> mockDesserts() {
        return new ArrayList<>(){{
            add(new ThanksgivingMenuItemRecord("Pumpkin Pie", "Traditional"));
            add(new ThanksgivingMenuItemRecord("Coconut Cake", "Layered"));
        }};
    }

    public ThanksgivingInvitation createInvitation(CreateInvitationCommand createInvitationCommand) {
        Log.debugf("Creating invitation for %s", createInvitationCommand.thanksgivingMenuRecord());
        return new ThanksgivingInvitation(URI.create("http://localhost:8080/static/thanksgiving-menu-01.jpg"), createInvitationCommand.thanksgivingMenuRecord());
    }
}
