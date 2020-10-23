package com.example;

import com.example.model.Question;
import com.example.service.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorTest {
    private Question question;
    private List<String> intergalacticNumber;
    private Calculator calculator;

    @BeforeEach
    public void initialise(){
        intergalacticNumber = new ArrayList();
        question = new Question(intergalacticNumber, null);
        calculator = new Calculator();
    }

    @Test
    public void shouldCalculateValue() {
        intergalacticNumber.addAll(Arrays.asList("glob", "glob"));

        Assertions.assertEquals(2, calculator.calculate(question));
    }
}
