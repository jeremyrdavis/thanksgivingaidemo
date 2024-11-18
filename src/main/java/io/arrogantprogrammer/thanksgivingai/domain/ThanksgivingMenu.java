package io.arrogantprogrammer.thanksgivingai.domain;

import io.arrogantprogrammer.thanksgivingai.api.ThanksgivingMenuRecord;
import io.arrogantprogrammer.thanksgivingai.utils.PostalCodeUtility;

import java.util.List;

public class ThanksgivingMenu {

    public static String createPrompt(List<String> states) {
        if (states != null && states.size() == 0) {
            return NONE_PROMPT;
        }else if (states.size() == 1) {
            if("None".equals(states.get(0))){
                return NONE_PROMPT;
            }else{
                return String.format(SINGLE_PROMPT, PostalCodeUtility.getStateNameFromPostalStateCode(states.get(0)), states.get(0), states.get(0));
            }
        }else{
            return NONE_PROMPT;
        }
    }


    protected static final String NONE_PROMPT = "Create a Thanksgiving menu that combines traditional dishes with modern American inspired dishes. The menu should have 2 mains, one of which should be turkey, at least 4 side items, and at least 1 dessert. Each main, side, and dessert should have a name and a brief description, for example, name: Turkey description: Citrus Brined and Roasted. Return the menu in the following json format: { \\\"mains\\\":[{\\\"item\\\": \\\"string\\\"}] ,\\\"sides\\\":[{\\\"item\\\":\\\"string\\\",\\\"description\\\":\\\"string\\\"}],\\\"desserts\\\":[{\\\"item\\\":string\\\",\\\"description\\\":\\\"string\\\"}]. Also include the the name of the model being used in the following json format, {\\\"model\\\":\\\"string\\\"}, and the stateCode in the following format, {\\\"stateCode\\\" : \\\"None\\\"}. Return only json in the specified, valid format.";

    protected static final String SINGLE_PROMPT = "Create a Thanksgiving menu that combines traditional dishes with %s inspired dishes. The menu should have 2 mains, one of which should be turkey, at least 4 side items, and at least 1 dessert. Each main, side, and dessert should have a name and a brief description, for example, name: Turkey description: Citrus Brined and Roasted. Return the menu in the following json format: { \\\"mains\\\":[{\\\"item\\\": \\\"string\\\"}] ,\\\"sides\\\":[{\\\"item\\\":\\\"string\\\",\\\"description\\\":\\\"string\\\"}],\\\"desserts\\\":[{\\\"item\\\":string\\\",\\\"description\\\":\\\"string\\\"}]. Also include the the name of the model being used in the following json format, {\\\"model\\\":\\\"string\\\"}, and the stateCode in the following format, {\\\"stateCode\\\" : \\\"%s\\\"}. Return only json in the specified, valid format.";

}
