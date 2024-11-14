package io.arrogantprogrammer.thanksgivingai;

import io.arrogantprogrammer.thanksgivingai.api.CreateInvitationCommand;
import io.arrogantprogrammer.thanksgivingai.api.CreateMenuCommand;
import io.arrogantprogrammer.thanksgivingai.api.ThanksgivingInvitation;
import io.arrogantprogrammer.thanksgivingai.api.ThanksgivingMenu;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class AiServiceTest {

    @Inject
    AiService aiService;

    @Test
    public void testAiService() {
        ThanksgivingMenu thanksgivingMenu = aiService.createMenu(new CreateMenuCommand("jeremy.davis@redhat.com", List.of("None")));
        assertNotNull(thanksgivingMenu);
        assertEquals(thanksgivingMenu.email(), "jeremy.davis@redhat.com");
        assertTrue(thanksgivingMenu.mains().size() >= 1);
        assertTrue(thanksgivingMenu.sides().size() >= 2);
        assertTrue(thanksgivingMenu.desserts().size() >= 1);
    }

    @Test
    public void testCreateInvitation() {
        CreateInvitationCommand createInvitationCommand = MockObjects.createInvitationCommand();
        ThanksgivingInvitation thanksgivingInvitation = aiService.createInvitation(createInvitationCommand);
        assertNotNull(thanksgivingInvitation.thanksgivingMenu());
        assertEquals(thanksgivingInvitation.thanksgivingMenu().email(), MockObjects.EMAIL);
        assertEquals(thanksgivingInvitation.thanksgivingMenu().mains().size(), MockObjects.mains().size());
        assertEquals(thanksgivingInvitation.thanksgivingMenu().sides().size(), MockObjects.sides().size());
        assertEquals(thanksgivingInvitation.thanksgivingMenu().desserts().size(), MockObjects.desserts().size());
    }
}
