package com.example.service.parser;

import com.example.exception.InvalidAssertionException;
import com.example.model.RomanDigit;

import java.util.Map;

public abstract class AssertionParser extends Parser {

    public AssertionParser(Map<String, RomanDigit> intergalacticMap) {
        super(intergalacticMap);
    }

    public abstract void parse(String assertion) throws InvalidAssertionException;
}
