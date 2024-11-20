package io.arrogantprogrammer.thanksgivingai;

import dev.langchain4j.model.image.ImageModel;
import io.arrogantprogrammer.thanksgivingai.api.*;
import io.arrogantprogrammer.thanksgivingai.domain.ThanksgivingMenu;
import io.arrogantprogrammer.thanksgivingai.rest.ChatGPTService;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class AiService {

    @Inject
    ChatGPTService chatGPTService;

    @Inject
    ImageModel imageModel;

    public URL imageUrl(final ThanksgivingMenuRecord thanksgivingMenuRecord) {

        String prompt = ThanksgivingMenu.createInvitationPrompt(thanksgivingMenuRecord);

        var image = imageModel.generate(prompt);
        var uri = image.content().url();
        var desc = image.content().revisedPrompt();
        try {
            var file = new File(UUID.randomUUID() + ".png");
            Files.copy(uri.toURL().openStream(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
            Log.debugf("file://" + file.getAbsolutePath());
            return uri.toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
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
