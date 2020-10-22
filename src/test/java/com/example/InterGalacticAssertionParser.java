package com.example;

import com.example.exception.InvalidAssertionException;
import com.example.exception.InvalidInputException;
import com.example.model.RomanDigit;
import com.example.service.AsserionParser;
import com.example.service.Parser;

import java.util.Map;

public class InterGalacticAssertionParser extends AsserionParser {
    public InterGalacticAssertionParser(Map<String, RomanDigit> intergalacticMap) {
        super(intergalacticMap);
    }

    @Override
    public void parse(String assertion) throws InvalidInputException, InvalidAssertionException {
        if (assertion == null || assertion.isEmpty()) {
            throw new InvalidInputException();
        }

        String[] assertParams = assertion.split(Parser.IS);

        if (assertParams.length == 2) {
            try {
                RomanDigit digit = Enum.valueOf(RomanDigit.class, assertParams[1]);
                intergalacticMap.put(assertParams[0], digit);
            } catch (IllegalArgumentException e) {
                throw new InvalidAssertionException(e);
            }
        }

        throw new InvalidAssertionException();
    }
}
