package io.arrogantprogrammer.thanksgivingai.api;

import java.util.List;

public record ThanksgivingMenu(String email, List<String> mains, List<String> sides, List<String> desserts) {
}
