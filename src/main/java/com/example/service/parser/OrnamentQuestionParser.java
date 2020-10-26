package com.example.service.parser;

import com.example.exception.InvalidQuestionException;
import com.example.model.Question;
import com.example.model.RomanDigit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrnamentQuestionParser extends QuestionParser {
    private Map<String, Double> ornamentMap;
    public static final String HOW_MANY_CREDITS_IS_ = "how many Credits is ";

    public OrnamentQuestionParser(Map<String, RomanDigit> intergalacticMap, Map<String, Double> ornamentMap) {
        super(intergalacticMap);
        this.ornamentMap = ornamentMap;
    }

    @Override
    public Question parse(String questionStr) throws InvalidQuestionException {

        questionStr = questionStr.replace(HOW_MANY_CREDITS_IS_, "");
        questionStr = questionStr.replace(QUESTION_MARK, "");

        List<String> intergalacticOrnamentNumber = new ArrayList<>(Arrays.asList(questionStr.split(" ")));
        String ornament = intergalacticOrnamentNumber.get(intergalacticOrnamentNumber.size() - 1);

        intergalacticOrnamentNumber.remove(intergalacticOrnamentNumber.size()-1);

        if (isValidRomanNumber(intergalacticOrnamentNumber) && intergalacticMap.get(ornament) == null) {
            return new Question(intergalacticOrnamentNumber, ornament);
        }

        throw new InvalidQuestionException();
    }
}
