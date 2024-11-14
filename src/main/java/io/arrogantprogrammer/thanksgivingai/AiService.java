package io.arrogantprogrammer.thanksgivingai;

import io.arrogantprogrammer.thanksgivingai.api.CreateMenuCommand;
import io.arrogantprogrammer.thanksgivingai.api.ThanksgivingMenu;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class AiService {

    public ThanksgivingMenu createMenu(CreateMenuCommand createMenuCommand) {
        return new ThanksgivingMenu(createMenuCommand.email(), mockMains(), mockSides(), mockDesserts());
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
}
