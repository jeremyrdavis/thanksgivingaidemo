package io.arrogantprogrammer.thanksgivingai;

import io.arrogantprogrammer.thanksgivingai.api.CreateInvitationCommand;
import io.arrogantprogrammer.thanksgivingai.api.ThanksgivingMenu;

import java.util.List;

public class MockObjects {

    public static final String EMAIL = "jeremy.davis@redhat.com";

    public static CreateInvitationCommand createInvitationCommand() {
        return new CreateInvitationCommand(MockObjects.thanksgivingMenu());
    }

    public static ThanksgivingMenu thanksgivingMenu() {
        return new ThanksgivingMenu(EMAIL, MockObjects.mains(), MockObjects.sides(), MockObjects.desserts());
    }

    public static List<String> mains() {
        return List.of("Turkey", "Ham");
    }

    public static List<String> sides() {
        return List.of("Mashed Potatoes", "Green Bean Casserole", "Cranberry Sauce");
    }

    public static List<String> desserts() {
        return List.of("Pumpkin Pie");
    }
}
