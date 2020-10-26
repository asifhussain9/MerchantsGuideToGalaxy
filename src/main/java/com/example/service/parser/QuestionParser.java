package com.example.service.parser;

import com.example.exception.InvalidQuestionException;
import com.example.model.Question;
import com.example.model.RomanDigit;

import java.util.Map;

public abstract class QuestionParser extends Parser {

    public static final String QUESTION_MARK = " ?";

    public QuestionParser(Map<String, RomanDigit> intergalacticMap) {
        super(intergalacticMap);
    }

    public abstract Question parse(String questionStr) throws InvalidQuestionException;
}
