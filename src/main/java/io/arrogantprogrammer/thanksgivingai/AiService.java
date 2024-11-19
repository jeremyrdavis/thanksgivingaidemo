package io.arrogantprogrammer.thanksgivingai;

import dev.langchain4j.model.image.ImageModel;
import io.arrogantprogrammer.thanksgivingai.api.*;
import io.arrogantprogrammer.thanksgivingai.domain.ThanksgivingMenu;
import io.arrogantprogrammer.thanksgivingai.rest.ChatGPTService;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AiService {

    @Inject
    ChatGPTService chatGPTService;

    @Inject
    ImageModel imageModel;

    public URL imageUrl() {
        var response = imageModel.generate("Create a menu for Thanksgiving dinner.");
        try {
            return response.content().url().toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public ThanksgivingMenuRecord createMenu(CreateMenuCommand createMenuCommand) {
        String prompt = ThanksgivingMenu.createPrompt(createMenuCommand.stateCodes());
        ThanksgivingMenuRecord result = chatGPTService.chat(prompt);
        Log.debugf("Created menu %s", result);
        return result;
    }

    public ThanksgivingInvitation createInvitation(CreateInvitationCommand createInvitationCommand) {
        Log.debugf("Creating invitation for %s", createInvitationCommand.thanksgivingMenuRecord());
        try {
            return new ThanksgivingInvitation(new URL("http://localhost:8080/static/thanksgiving-menu-01.jpg"), createInvitationCommand.thanksgivingMenuRecord());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
