package io.arrogantprogrammer.thanksgivingai.rest;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.arrogantprogrammer.thanksgivingai.api.ThanksgivingMenuRecord;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.SessionScoped;

@RegisterAiService()
@SessionScoped
public interface ChatGPTService {

    @SystemMessage({
            "You are a chef specializing in local dishes and ingredients. You are preparing a Thanksgiving feast for your family and friends.",
    })
    ThanksgivingMenuRecord chat(@UserMessage String userMessage);

}
