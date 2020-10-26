package com.example;

import com.example.exception.InvalidAssertionException;
import com.example.model.RomanDigit;
import com.example.service.parser.InterGalacticAssertionParser;
import com.example.service.parser.OrnamentAssertionParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class AssertionParserTest {
    Map<String, RomanDigit> intergalacticMap;
    private InterGalacticAssertionParser intergalacticParser;
    private Map<String, Double> ornamentValueMap;
    private OrnamentAssertionParser ornamentAssertionParser;

    @BeforeEach
    public void initialise(){
        intergalacticMap = new HashMap();
        ornamentValueMap = new HashMap();
        intergalacticParser = new InterGalacticAssertionParser(intergalacticMap);
        ornamentAssertionParser = new OrnamentAssertionParser(intergalacticMap, ornamentValueMap);
    }

    @Test
    public void shouldParseAssertionAndUpdateInterGalacticMap() throws InvalidAssertionException {
        intergalacticParser.parse("glob is I");

        Assertions.assertEquals(intergalacticMap.get("glob"), RomanDigit.I);
    }

    @Test
    public void shouldThrowInvalidAssertionExceptionForIncorrectIntergalacticAssertion() {
        Assertions.assertThrows(InvalidAssertionException.class, ()->intergalacticParser.parse("glob is J"));
    }

    @Test
    public void shouldParseAssertionAndUpdateMaterialMap() throws InvalidAssertionException {
        intergalacticMap.put("glob", RomanDigit.I);
        ornamentAssertionParser.parse("glob glob Silver is 34 Credits");

        Assertions.assertEquals(ornamentValueMap.get("Silver"), 17);
    }
}
