package com.example;

import com.example.controller.AssertionController;
import com.example.controller.QuestionController;
import com.example.model.RomanDigit;
import com.example.service.parser.IntergalacticQuestionParser;
import com.example.service.parser.OrnamentQuestionParser;
import com.example.service.parser.QuestionParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class TranslatorControllerTest {
    static final List<String> assertions = Collections.unmodifiableList(Arrays.asList(new String[]{"glob is I",
            "prok is V",
            "pish is X",
            "tegj is L",
            "glob glob Silver is 34 Credits",
            "glob prok Gold is 57800 Credits",
            "pish pish Iron is 3910 Credits"}));

    static final List<String> questions = Collections.unmodifiableList(Arrays.asList(new String[]{"how much is pish tegj glob glob ?",
            "how many Credits is glob prok Silver ?",
            "how many Credits is glob prok Gold ?",
            "how many Credits is glob prok Iron ?",
            "how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"}));

    String[] answers = {"pish tegj glob glob is 42",
            "glob prok Silver is 68 Credits",
            "glob prok Gold is 57800 Credits",
            "glob prok Iron is 782 Credits",
            "I have no idea what you are talking about"};

    @TestFactory
    Stream<DynamicTest> dynamicTestGenerator() throws IOException {
        Map<String, RomanDigit> intergalacticMap = new HashMap<>();
        Map<String, Double> ornamentMap = new HashMap<>();

        Stream<DynamicTest> assertionTestStream = assertions.stream()
                .map(assertion -> {
                    return DynamicTest.dynamicTest(assertion, () -> {
                        AssertionController.parse(intergalacticMap, ornamentMap, assertion);
                    });
                });

        Stream<DynamicTest> questionTestStream = DynamicTest.stream(
                questions.iterator(),
                question -> question.replace(IntergalacticQuestionParser.HOW_MUCH_IS_, "").replace(OrnamentQuestionParser.HOW_MANY_CREDITS_IS_, "").replace(QuestionParser.QUESTION_MARK, ""),
                question -> {
                    String answer = QuestionController.parse(intergalacticMap, ornamentMap, question);
                    int questionIndex = questions.indexOf(question);
                    DynamicTest.dynamicTest(question, () -> Assertions.assertEquals(answers[questionIndex], answer));
                }
        );

        return Stream.<DynamicTest>concat(assertionTestStream, questionTestStream);
    }
}
