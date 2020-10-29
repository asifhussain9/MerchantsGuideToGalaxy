package com.example;

import com.example.exception.InvalidAssertionException;
import com.example.model.RomanDigit;
import com.example.service.parser.InterGalacticAssertionParser;
import com.example.service.parser.OrnamentAssertionParser;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class AssertionParserTest {
    Map<String, RomanDigit> intergalacticMap;
    private InterGalacticAssertionParser intergalacticParser;
    private Map<String, Double> ornamentValueMap;
    private OrnamentAssertionParser ornamentAssertionParser;

    @BeforeEach
    public void initialise(){
        intergalacticMap = new HashMap<>();
        ornamentValueMap = new HashMap<>();
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

    @TestFactory
    Stream<DynamicTest> dynamicTestGenerator() throws IOException {

        return Files.lines(Paths.get("inputs.txt")).limit(4)
                .map(line ->
                        DynamicTest.dynamicTest(line, () -> {
                            intergalacticParser.parse(line);
                        })
                );
    }
}
