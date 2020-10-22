package com.example;

import com.example.exception.InvalidAssertionException;
import com.example.exception.InvalidInputException;
import com.example.model.RomanDigit;
import com.example.service.AsserionParser;
import com.example.service.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class AssertionParserTest {
    Map<String, RomanDigit> intergalacticMap;

    @BeforeEach
    public void initialise(){
        intergalacticMap = new HashMap();
    }

    @Test
    public void shouldParseAssertionAndUpdateInterGalacticMap() throws InvalidAssertionException {
        AsserionParser parser = new InterGalacticAssertionParser(intergalacticMap);
        parser.parse("glob is I");

        Assertions.assertEquals(intergalacticMap.get("glob"), RomanDigit.I);
    }
}
