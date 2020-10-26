package com.example.service.parser;

import com.example.exception.InvalidAssertionException;
import com.example.model.Question;
import com.example.model.RomanDigit;
import com.example.service.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class OrnamentAssertionParser extends AssertionParser {
    private Map<String, Double> ornamentValueMap;

    public OrnamentAssertionParser(Map<String, RomanDigit> intergalacticMap, Map<String, Double> ornamentValueMap) {
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

                IntStream.range(0, ornamentStrLHS.length - 1).forEach(i -> intergalacticNumber.add(ornamentStrLHS[i]));

                if (isValidRomanNumber(intergalacticNumber)) {
                    double intergalacticValue = intergalacticNumber.isEmpty() ? 1 : new Calculator(intergalacticMap, ornamentValueMap)
                            .calculate(new Question(intergalacticNumber, ""));
                    double ornamentValue = intergalacticValue == 0 ? value : value / intergalacticValue;
                    ornamentValueMap.put(ornamentName, ornamentValue);
                } else {
                    throw new InvalidAssertionException();
                }
            } catch (NumberFormatException e) {
                throw new InvalidAssertionException(e);
            }
            return;
        }

        throw new InvalidAssertionException();
    }
}
