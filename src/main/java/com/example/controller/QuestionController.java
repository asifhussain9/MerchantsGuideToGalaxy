package com.example.controller;

import com.example.exception.InvalidQuestionException;
import com.example.model.Question;
import com.example.model.RomanDigit;
import com.example.service.Calculator;
import com.example.service.parser.IntergalacticQuestionParser;
import com.example.service.parser.OrnamentQuestionParser;
import com.example.service.parser.Parser;
import com.example.service.parser.QuestionParser;

import java.math.BigDecimal;
import java.util.Map;

public class QuestionController {
    public static String parse(Map<String, RomanDigit> intergalacticMap, Map<String, Double> ornamentValueMap, String questionStr) {
        QuestionParser parser = questionStr.contains(Parser.CREDITS) ? new OrnamentQuestionParser(intergalacticMap, ornamentValueMap) : new IntergalacticQuestionParser(intergalacticMap);
        String answer = "";

        try {
            Question question = parser.parse(questionStr);
            double answerValue = new Calculator(intergalacticMap, ornamentValueMap).calculate(question);
            String questionTypeStr = questionStr.contains(Parser.CREDITS) ? OrnamentQuestionParser.HOW_MANY_CREDITS_IS_ : IntergalacticQuestionParser.HOW_MUCH_IS_;
            String answerTypeStr = questionStr.contains(Parser.CREDITS) ? Parser.CREDITS : "";
            answer = questionStr
                    .replace(questionTypeStr, "")
                    .replace(QuestionParser.QUESTION_MARK, "")
                    + Parser.IS
                    + BigDecimal.valueOf(answerValue).longValue()
                    + answerTypeStr;
        } catch (InvalidQuestionException e) {
            answer = "I have no idea what you are talking about";
        }

        return answer;
    }
}
