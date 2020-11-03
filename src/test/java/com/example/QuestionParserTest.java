package com.example;

import com.example.exception.InvalidQuestionException;
import com.example.model.Question;
import com.example.model.RomanDigit;
import com.example.service.parser.IntergalacticQuestionParser;
import com.example.service.parser.OrnamentQuestionParser;
import com.example.service.parser.QuestionParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class QuestionParserTest {
    private Map<String, RomanDigit> intergalacticMap;
    private Map<String, Double> ornamentMap;
    private QuestionParser parser;

    @BeforeEach
    public void initialise() {
        intergalacticMap = new HashMap<>();
        ornamentMap = new HashMap<>();

        intergalacticMap.put("glob", RomanDigit.I);
        intergalacticMap.put("prok", RomanDigit.V);
        intergalacticMap.put("pish", RomanDigit.X);
        intergalacticMap.put("tegj", RomanDigit.L);
    }

    @Test
    public void shouldParseIntergalacticQuestionAndReturnQuestionObject() throws InvalidQuestionException {
        String questionStr = "how much is pish tegj glob glob ?";
        parser = new IntergalacticQuestionParser(intergalacticMap);
        Question question = parser.parse(questionStr);

        Assertions.assertEquals(question.getIntergalacticNumber().size(), 4);
        Assertions.assertEquals(question.getIntergalacticNumber().get(0), "pish");
        Assertions.assertEquals(question.getIntergalacticNumber().get(1), "tegj");
        Assertions.assertEquals(question.getIntergalacticNumber().get(2), "glob");
        Assertions.assertEquals(question.getIntergalacticNumber().get(3), "glob");
    }

    @Test
    public void shouldThrowExceptionForInvalidQuestion() {
        String questionStr = "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?";
        parser = new IntergalacticQuestionParser(intergalacticMap);

        Assertions.assertThrows(InvalidQuestionException.class, () -> parser.parse(questionStr));
    }

    @Test
    public void shouldParseOrnamentQuestionAndReturnQuestionObject() throws InvalidQuestionException {
        String questionStr = "how many Credits is glob prok Iron ?";
        parser = new OrnamentQuestionParser(intergalacticMap, ornamentMap);
        Question question = parser.parse(questionStr);

        Assertions.assertEquals(question.getIntergalacticNumber().size(), 2);
        Assertions.assertEquals(question.getOrnament(), "Iron");
        Assertions.assertEquals(question.getIntergalacticNumber().get(0), "glob");
        Assertions.assertEquals(question.getIntergalacticNumber().get(1), "prok");
    }

    @Test
    public void shouldThrowExceptionForInvalidOrnamentQuestion() {
        String questionStr = "how many Credits is glob prok prok ?";
        parser = new OrnamentQuestionParser(intergalacticMap, ornamentMap);

        Assertions.assertThrows(InvalidQuestionException.class, () -> parser.parse(questionStr));
    }
}
