package com.example.service;

import com.example.model.Question;
import com.example.model.RomanDigit;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

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
        if(romanNumberOpt.isPresent()){
            String romanNumberStr = romanNumberOpt.get();
            for(String pattern : RomanDigit.subtractionPatternValueMap.keySet()){
                if(romanNumberStr.contains(pattern)){
                    romanNumberStr = romanNumberStr.replace(pattern, "");
                    romanValue += RomanDigit.subtractionPatternValueMap.get(pattern);
                }
            }

            romanValue += Pattern.compile("")
                    .splitAsStream(romanNumberStr)
                    .mapToDouble(digit -> RomanDigit.valueOf(digit).getValue()).reduce((v1, v2) -> v1 + v2)
                    .orElse(0);
        }

        double result = romanValue;

        if(!question.getOrnament().isEmpty()){
            result = result == 0 ? 1 : result;
            result *= ornamentMap.get(question.getOrnament());
        }

        return result;
    }
}
