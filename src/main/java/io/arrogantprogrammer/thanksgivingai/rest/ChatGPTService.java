package io.arrogantprogrammer.thanksgivingai.rest;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.arrogantprogrammer.thanksgivingai.ai.OutputRelevanceGuardrail;
import io.arrogantprogrammer.thanksgivingai.api.ThanksgivingMenuRecord;
import io.arrogantprogrammer.thanksgivingai.domain.ThanksgivingMenuItemRepository;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.quarkiverse.langchain4j.ToolBox;
import io.quarkiverse.langchain4j.guardrails.OutputGuardrails;
import jakarta.enterprise.context.SessionScoped;

@RegisterAiService()
@SessionScoped
public interface ChatGPTService {

    @SystemMessage({
            "You are a chef specializing in local dishes and ingredients. You are preparing a Thanksgiving feast for your family and friends.",
    })
    @OutputGuardrails(OutputRelevanceGuardrail.class)
    @ToolBox(ThanksgivingMenuItemRepository.class)
    ThanksgivingMenuRecord chat(@UserMessage String userMessage);

}
