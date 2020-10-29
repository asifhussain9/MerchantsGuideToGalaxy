package com.example.service.parser;

import com.example.model.RomanDigit;
import com.sun.istack.internal.NotNull;

import java.util.List;
import java.util.Map;

public class Parser {
    public static final String CREDITS = " Credits";
    public static final String IS = " is ";
    protected Map<String, RomanDigit> intergalacticMap;

    public Parser(Map<String, RomanDigit> intergalacticMap) {
        this.intergalacticMap = intergalacticMap;
    }

    public boolean areDigitsValid(List<String> intergalacticNumber) {
        return intergalacticNumber.stream().allMatch(intergalacticword -> intergalacticMap.get(intergalacticword) != null);
    }

    public boolean isValidRomanNumber(@NotNull List<String> intergalacticNumber) {
        if (areDigitsValid(intergalacticNumber)) {
            String romanNumberStr = intergalacticNumber.stream()
                    .reduce((w1, w2) -> {
                        RomanDigit digit1 = intergalacticMap.get(w1);
                        return digit1 == null ? w1 : digit1.name() + intergalacticMap.get(w2).name();
                    })
                    .orElse("");
            return intergalacticNumber.isEmpty() || (RomanDigit.isValidRepititions(romanNumberStr) && RomanDigit.isValidCombinations(romanNumberStr));
        }

        return false;
    }
}
