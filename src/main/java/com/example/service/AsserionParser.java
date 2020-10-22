package com.example.service;

import com.example.exception.InvalidAssertionException;
import com.example.exception.InvalidInputException;
import com.example.model.RomanDigit;

import java.util.Map;

public abstract class AsserionParser{

    protected Map<String, RomanDigit> intergalacticMap;

    public AsserionParser(Map<String, RomanDigit> intergalacticMap) {
        this.intergalacticMap = intergalacticMap;
    }

    public abstract void parse(String assertion) throws InvalidInputException, InvalidAssertionException;
}
