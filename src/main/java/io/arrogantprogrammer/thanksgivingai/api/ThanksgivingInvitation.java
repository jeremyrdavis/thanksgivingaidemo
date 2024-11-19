package io.arrogantprogrammer.thanksgivingai.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.net.URL;

public record ThanksgivingInvitation(URL invitationUri, @JsonProperty("thanksgivingMenu") ThanksgivingMenuRecord thanksgivingMenuRecord) {
}
