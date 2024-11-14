package io.arrogantprogrammer.thanksgivingai.api;

import java.util.List;

public record ThanksgivingMenu(String email, List<ThanksgivingMenuItem> mains, List<ThanksgivingMenuItem> sides, List<ThanksgivingMenuItem> desserts) {
}
