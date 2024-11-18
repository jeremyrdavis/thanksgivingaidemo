package io.arrogantprogrammer.thanksgivingai.utils;

import java.util.HashMap;
import java.util.Map;

public class PostalCodeUtility {

    public static String getStateNameFromPostalStateCode(String postalStateCode) {
        return postalCodeMappings.get(postalStateCode).stateName();
    }

    public static final Map<String, PostCodeMapping> postalCodeMappings = new HashMap() {{
        put("PR", new PostCodeMapping("PR", "Puerto Rico", "SOUTHERN"));
        put("VI", new PostCodeMapping("VI", "Virgin Islands", "SOUTHERN"));
        put("MA", new PostCodeMapping("MA", "Massachusetts", "ATLANTIC"));
        put("RI", new PostCodeMapping("RI", "Rhode Island", "ATLANTIC"));
        put("NH", new PostCodeMapping("NH", "New Hampshire", "ATLANTIC"));
        put("ME", new PostCodeMapping("ME", "Maine", "ATLANTIC"));
        put("VT", new PostCodeMapping("VT", "Vermont", "ATLANTIC"));
        put("CT", new PostCodeMapping("CT", "Connecticut", "ATLANTIC"));
        put("NY", new PostCodeMapping("NY", "New York", "ATLANTIC"));
        put("NJ", new PostCodeMapping("NJ", "New Jersey", "ATLANTIC"));
        put("PA", new PostCodeMapping("PA", "Pennsylvania", "ATLANTIC"));
        put("DE", new PostCodeMapping("DE", "Delaware", "ATLANTIC"));
        put("MD", new PostCodeMapping("MD", "Maryland", "ATLANTIC"));
        put("DC", new PostCodeMapping("DC", "District of Columbia", "ATLANTIC"));
        put("VA", new PostCodeMapping("VA", "Virginia", "ATLANTIC"));
        put("WV", new PostCodeMapping("WV", "West Virginia", "CENTRAL"));
        put("NC", new PostCodeMapping("NC", "North Carolina", "ATLANTIC"));
        put("SC", new PostCodeMapping("SC", "South Carolina", "SOUTHERN"));
        put("GA", new PostCodeMapping("GA", "Georgia", "SOUTHERN"));
        put("TN", new PostCodeMapping("TN", "Tennessee", "SOUTHERN"));
        put("FL", new PostCodeMapping("FL", "Florida", "SOUTHERN"));
        put("AL", new PostCodeMapping("AL", "Alabama", "SOUTHERN"));
        put("KY", new PostCodeMapping("KY", "Kentucky", "CENTRAL"));
        put("MS", new PostCodeMapping("MS", "Mississippi", "SOUTHERN"));
        put("OH", new PostCodeMapping("OH", "Ohio", "CENTRAL"));
        put("IN", new PostCodeMapping("IN", "Indiana", "CENTRAL"));
        put("MI", new PostCodeMapping("MI", "Michigan", "CENTRAL"));
        put("IA", new PostCodeMapping("IA", "Iowa", "CENTRAL"));
        put("NE", new PostCodeMapping("NE", "Nebraska", "CENTRAL"));
        put("WI", new PostCodeMapping("WI", "Wisconsin", "CENTRAL"));
        put("MN", new PostCodeMapping("MN", "Minnesota", "CENTRAL"));
        put("ND", new PostCodeMapping("ND", "North Dakota", "CENTRAL"));
        put("SD", new PostCodeMapping("SD", "South Dakota", "WESTPAC"));
        put("MT", new PostCodeMapping("MT", "Montana", "WESTPAC"));
        put("IL", new PostCodeMapping("IL", "Illinois", "CENTRAL"));
        put("MO", new PostCodeMapping("MO", "Missouri", "CENTRAL"));
        put("KS", new PostCodeMapping("KS", "Kansas", "CENTRAL"));
        put("LA", new PostCodeMapping("LA", "Louisiana", "SOUTHERN"));
        put("AR", new PostCodeMapping("AR", "Arkansas", "SOUTHERN"));
        put("TX", new PostCodeMapping("TX", "Texas", "SOUTHERN"));
        put("OK", new PostCodeMapping("OK", "Oklahoma", "SOUTHERN"));
        put("NM", new PostCodeMapping("NM", "New Mexico", "WESTPAC"));
        put("CO", new PostCodeMapping("CO", "Colorado", "WESTPAC"));
        put("WY", new PostCodeMapping("WY", "Wyoming", "WESTPAC"));
        put("ID", new PostCodeMapping("ID", "Idaho", "WESTPAC"));
        put("WA", new PostCodeMapping("WA", "Washington", "WESTPAC"));
        put("UT", new PostCodeMapping("UT", "Utah", "WESTPAC"));
        put("AZ", new PostCodeMapping("AZ", "Arizona", "WESTPAC"));
        put("NV", new PostCodeMapping("NV", "Nevada", "WESTPAC"));
        put("CA", new PostCodeMapping("CA", "California", "WESTPAC"));
        put("HI", new PostCodeMapping("HI", "Hawaii", "WESTPAC"));
        put("AS", new PostCodeMapping("AS", "American Samoa", "WESTPAC"));
        put("GU", new PostCodeMapping("GU", "Guam", "WESTPAC"));
        put("PW", new PostCodeMapping("PW", "None", "WESTPAC"));
        put("FM", new PostCodeMapping("FM", "None", "WESTPAC"));
        put("MP", new PostCodeMapping("MP", "Northern Mariana Islands", "WESTPAC"));
        put("MH", new PostCodeMapping("MH", "None", "WESTPAC"));
        put("OR", new PostCodeMapping("OR", "Oregon", "WESTPAC"));
        put("AK", new PostCodeMapping("AK", "Alaska", "WESTPAC"));
    }};
}