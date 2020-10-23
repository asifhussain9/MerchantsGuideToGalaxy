package com.example.service;

import com.example.exception.InvalidAssertionException;
import com.example.model.Question;
import com.example.model.RomanDigit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrnamentParser extends AsserionParser {
    private Map<String, Double> ornamentValueMap;

    public OrnamentParser(Map<String, RomanDigit> intergalacticMap, Map<String, Double> ornamentValueMap) {
        super(intergalacticMap);

        this.ornamentValueMap = ornamentValueMap;
    }

    public void parse(String assertion) throws InvalidAssertionException {
        boolean isCreditStr = assertion.endsWith(Parser.CREDITS);
        assertion = assertion.replace(Parser.CREDITS, "");
        String[] ornamentStr = assertion.split(Parser.IS);

        if (ornamentStr.length == 2) {
            try {
                double value = Double.parseDouble(ornamentStr[1]);
                String[] ornamentStrLHS = ornamentStr[0].split(" ");
                String ornamentName = ornamentStrLHS[ornamentStrLHS.length - 1];
                List<String> intergalacticNumber = new ArrayList();

                for (int i = 0; i < ornamentStrLHS.length - 1; i++) {
                    try {
                        intergalacticNumber.add(ornamentStrLHS[i]);
                    } catch (IllegalArgumentException e) {
                        throw new InvalidAssertionException(e);
                    }
                }

                double intergalacticValue = intergalacticNumber.isEmpty() ? 1 : new Calculator().calculate(new Question(intergalacticNumber, null));
                double ornamentValue = intergalacticValue == 0 ? value : value / intergalacticValue;

                ornamentValueMap.put(ornamentName, ornamentValue);
            } catch (NumberFormatException e) {
                throw new InvalidAssertionException(e);
            }
            return;
        }

        throw new InvalidAssertionException();
    }
}
