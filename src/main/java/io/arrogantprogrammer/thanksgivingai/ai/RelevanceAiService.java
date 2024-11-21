package io.arrogantprogrammer.thanksgivingai.ai;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import io.quarkiverse.langchain4j.guardrails.OutputGuardrail;

@RegisterAiService
public interface RelevanceAiService extends OutputGuardrail {

    @SystemMessage("""
            You are a response validation system. You will validate whether a Thanksgiving menu makes sense and is appealing.
            Validation does not require access to an external system.
            """)
    @UserMessage("""
            Simply try to determine whether or not the menu makes sense.  Return a value between 0.0 and 1.0, where 1.0 means the menu does is not appealing, 0.5 is potentially appealing, and 0.0 is an appealing menu.  Do not return anything else. Do not even return a newline or a leading field. Only 'true' or 'false.'

            Example 1:
            menu: Stuffed, roasted basset hound
            1.0

            Example 2:
            menu: Turkey with grapefruit and coconut stuffing
            0.95

            Example 3:
            menu: Cedar plank roasted turkey
            0.5

            Example 4:
            menu: Turkey with cranberry sauce
            0.0

            Example 5:
            menu: Glazed ham
            0.0

            Example 6:
            menu: Green bean casserole
            0.0

            Menu: {menu}
            """)
    double isValid(String menu);
}
