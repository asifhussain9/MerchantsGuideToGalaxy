package com.example.controller;

import com.example.exception.InvalidAssertionException;
import com.example.model.RomanDigit;
import com.example.service.parser.AssertionParser;
import com.example.service.parser.InterGalacticAssertionParser;
import com.example.service.parser.OrnamentAssertionParser;
import com.example.service.parser.Parser;

import java.util.Map;


/**
 * A controller class that calls a suitable assertion parser based on assertion type
 *
 * @author Asif Hussain
 * @version 1.0
 *
 */
public class AssertionController {
    public static void parse(Map<String, RomanDigit> intergalacticMap, Map<String, Double> ornamentValueMap, String assertion) {
        AssertionParser parser = assertion.contains(Parser.CREDITS) ? new OrnamentAssertionParser(intergalacticMap, ornamentValueMap) : new InterGalacticAssertionParser(intergalacticMap);

        try {
            parser.parse(assertion);
        } catch (InvalidAssertionException e) {
            System.out.println("I have no idea what you're talking about");
        }
    }
}
