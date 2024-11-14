package io.arrogantprogrammer.thanksgivingai;

import io.arrogantprogrammer.thanksgivingai.api.CreateMenuCommand;
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
}
