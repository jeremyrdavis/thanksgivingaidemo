package io.arrogantprogrammer.thanksgivingai.api;

import java.util.List;

public record ThanksgivingMenuRecord(String email, List<ThanksgivingMenuItemRecord> mains, List<ThanksgivingMenuItemRecord> sides, List<ThanksgivingMenuItemRecord> desserts) {
}
