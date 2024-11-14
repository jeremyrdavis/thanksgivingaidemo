package io.arrogantprogrammer.thanksgivingai;

import io.arrogantprogrammer.thanksgivingai.api.CreateInvitationCommand;
import io.arrogantprogrammer.thanksgivingai.api.ThanksgivingMenu;
import io.arrogantprogrammer.thanksgivingai.api.ThanksgivingMenuItem;

import java.util.ArrayList;
import java.util.List;

public class MockObjects {

    public static final String EMAIL = "jeremy.davis@redhat.com";

    public static CreateInvitationCommand createInvitationCommand() {
        return new CreateInvitationCommand(MockObjects.thanksgivingMenu());
    }

    public static ThanksgivingMenu thanksgivingMenu() {
        return new ThanksgivingMenu(EMAIL, MockObjects.mains(), MockObjects.sides(), MockObjects.desserts());
    }

    public static List<ThanksgivingMenuItem> mains() {

        return new ArrayList<>(){{
            add(new ThanksgivingMenuItem("Turkey", "Roasted"));
            add(new ThanksgivingMenuItem( "Ham", "Honey Baked"));
            add(new ThanksgivingMenuItem("Tofurkey", "Vegan"));
        }};
    }

    public static List<ThanksgivingMenuItem> sides() {
        return new ArrayList<>(){{
            add(new ThanksgivingMenuItem("Mashed Potatoes", "Creamy"));
            add(new ThanksgivingMenuItem("Green Beans", "Almondine"));
            add(new ThanksgivingMenuItem("Cranberry Sauce", "Homemade"));
            add(new ThanksgivingMenuItem("Mac & Cheese", "Baked"));
        }};
    }

    public static List<ThanksgivingMenuItem> desserts() {
        return List.of(new ThanksgivingMenuItem("Pumpkin Pie", "Traditional"));
    }
}
