package com.example.service;

import com.example.model.Question;
import com.example.model.RomanDigit;

import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

public class Calculator {
    private Map<String, RomanDigit> intergalacticMap;
    private Map<String, Double> ornamentMap;

    public Calculator(Map<String, RomanDigit> intergalacticMap, Map<String, Double> ornamentMap) {
        this.intergalacticMap = intergalacticMap;
        this.ornamentMap = ornamentMap;
    }

    public double calculate(Question question) {
        Optional<String> romanNumberOpt = question.getIntergalacticNumber().stream().map(s -> intergalacticMap.get(s).name()).reduce((s1, s2) -> s1 + s2);
        double romanValue = 0;
        if (romanNumberOpt.isPresent()) {
            String romanNumberStr = romanNumberOpt.get();
            for (Map.Entry<String, Double> pattern : RomanDigit.subtractionPatternValueMap.entrySet()) {
                if (romanNumberStr.contains(pattern.getKey())) {
                    romanNumberStr = romanNumberStr.replace(pattern.getKey(), "");
                    romanValue += pattern.getValue();
                }
            }

            romanValue += Pattern.compile("")
                    .splitAsStream(romanNumberStr)
                    .mapToDouble(digit -> RomanDigit.valueOf(digit).getValue()).reduce((v1, v2) -> v1 + v2)
                    .orElse(0);
        }

        double result = romanValue;

        if (!question.getOrnament().isEmpty()) {
            result = result == 0 ? 1 : result;
            result *= ornamentMap.get(question.getOrnament());
        }

        return result;
    }
}
