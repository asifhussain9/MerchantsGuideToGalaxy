package com.example.service.parser;

import com.example.exception.InvalidQuestionException;
import com.example.model.Question;
import com.example.model.RomanDigit;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class IntergalacticQuestionParser extends QuestionParser {
    public static final String HOW_MUCH_IS_ = "how much is ";

    public IntergalacticQuestionParser(Map<String, RomanDigit> intergalacticMap) {
        super(intergalacticMap);
    }

    @Override
    public Question parse(String questionStr) throws InvalidQuestionException {
        questionStr = questionStr.replace(HOW_MUCH_IS_, "");
        questionStr = questionStr.replace(QUESTION_MARK, "");

        List<String> intergalacticNumber = Arrays.asList(questionStr.split(" "));

        if (isValidRomanNumber(intergalacticNumber)) {
            return new Question(intergalacticNumber, "");
        }


        throw new InvalidQuestionException();
    }
}
