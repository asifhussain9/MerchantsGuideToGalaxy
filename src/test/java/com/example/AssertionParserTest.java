package com.example;

import com.example.model.RomanDigit;
import com.example.service.AsserionParser;
import com.example.service.Parser;
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
    public void shouldParseAssertionAndUpdateInterGalacticMap(){
        Parser parser = new AssertionParser(intergalacticMap);
        AsserionParser.parse("glob is I");
    }
}
