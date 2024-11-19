package io.arrogantprogrammer.thanksgivingai.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;

public record ThanksgivingInvitation(URI invitationUri, @JsonProperty("thanksgivingMenu") ThanksgivingMenuRecord thanksgivingMenuRecord) {
}
