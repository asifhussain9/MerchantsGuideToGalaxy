package com.example;

import com.example.model.Question;
import com.example.model.RomanDigit;
import com.example.service.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CalculatorTest {
    private Question question;
    private List<String> intergalacticNumber;
    private Calculator calculator;
    private Map<String, RomanDigit> intergalacticMap;
    private Map<String, Double> ornamentMap;

    @BeforeEach
    public void initialise(){
        intergalacticNumber = new ArrayList();
        intergalacticMap = new HashMap<>();
        ornamentMap = new HashMap<>();

        intergalacticMap.put("glob", RomanDigit.I);
        intergalacticMap.put("prok", RomanDigit.V);
        intergalacticMap.put("pish", RomanDigit.X);
        intergalacticMap.put("tegj", RomanDigit.L);

        calculator = new Calculator(intergalacticMap, ornamentMap);
    }

    @Test
    public void shouldCalculateIntergalacticValue() {

        intergalacticNumber.addAll(Arrays.asList("glob", "prok"));
        question = new Question(intergalacticNumber, null);
        Assertions.assertEquals(4, calculator.calculate(question));
    }

    @Test
    public void shouldCalculateOrnamentValue(){
        intergalacticNumber.addAll(Arrays.asList("glob", "prok"));
        ornamentMap.put("Silver", 17D);
        question = new Question(intergalacticNumber, "Silver");

        Assertions.assertEquals(68D, new Calculator(intergalacticMap, ornamentMap).calculate(question));
    }
}
