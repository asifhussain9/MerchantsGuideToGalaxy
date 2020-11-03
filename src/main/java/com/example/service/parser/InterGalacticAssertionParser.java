package com.example.service.parser;

import com.example.exception.InvalidAssertionException;
import com.example.model.RomanDigit;

import java.util.Map;

/**
 * This class parses input with intergalactic to roman translation
 *
 * @author Asif Hussain
 * @version 1.0
 *
 */
public class InterGalacticAssertionParser extends AssertionParser {
    public InterGalacticAssertionParser(Map<String, RomanDigit> intergalacticMap) {
        super(intergalacticMap);
    }

    @Override
    public void parse(String assertion) throws InvalidAssertionException {
        if (assertion == null || assertion.isEmpty()) {
            throw new InvalidAssertionException();
        }

        String[] assertParams = assertion.split(Parser.IS);

        if (assertParams.length == 2) {
            try {
                RomanDigit digit = Enum.valueOf(RomanDigit.class, assertParams[1]);
                intergalacticMap.put(assertParams[0], digit);
                return;
            } catch (IllegalArgumentException e) {
                throw new InvalidAssertionException(e);
            }
        }

        throw new InvalidAssertionException();
    }
}