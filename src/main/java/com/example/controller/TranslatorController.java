package com.example.controller;

import com.example.model.RomanDigit;
import com.example.service.parser.QuestionParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A controller class that calls a suitable controller based on input type
 *
 * @author Asif Hussain
 * @version 1.0
 *
 */
public class TranslatorController {
    private static Map<String, RomanDigit> intergalacticMap = new HashMap<>();
    private static Map<String, Double> ornamentValueMap = new HashMap<>();
    private static List<String> answers = new ArrayList<>();

    public static void parse(String input) {
        boolean isQuestion = input.endsWith(QuestionParser.QUESTION_MARK);

        if (isQuestion) {
            String answer = QuestionController.answerTo(intergalacticMap, ornamentValueMap, input);
            answers.add(answer);
        } else {
            AssertionController.parse(intergalacticMap, ornamentValueMap, input);
        }
    }

    public static void printAnswers() {
        answers.forEach(System.out::println);
    }
}
