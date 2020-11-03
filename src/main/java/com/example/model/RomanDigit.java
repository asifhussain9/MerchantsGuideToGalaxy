package com.example.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum RomanDigit {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    public static final String NON_REPEATABLE_D = "DD";
    public static final String NON_REPEATABLE_L = "LL";
    public static final String NON_REPEATABLE_V = "VV";

    public static final String REPEATABLE_I = "IIII";
    public static final String REPEATABLE_X = "XXXX";
    public static final String REPEATABLE_C = "CCCC";
    public static final String REPEATABLE_M = "MMMM";

    public static final Map<String, Double> subtractionPatternValueMap;
    static final String[] invalidDigitRepititions = {NON_REPEATABLE_D, NON_REPEATABLE_L, NON_REPEATABLE_V, REPEATABLE_C, REPEATABLE_I, REPEATABLE_X, REPEATABLE_M};
    static final String[] invalidDigitCombinations = {"VX"};

    static {
        Map subtractionPatternMap = new HashMap();
        subtractionPatternMap.put("IV", 4D);
        subtractionPatternMap.put("IX", 9D);
        subtractionPatternMap.put("XL", 40D);
        subtractionPatternMap.put("XC", 90D);
        subtractionPatternMap.put("CD", 400D);
        subtractionPatternMap.put("CM", 900D);

        subtractionPatternValueMap = Collections.unmodifiableMap(subtractionPatternMap);
    }

    public static boolean isValidRepititions(String romanNumber) {
        return Arrays.stream(invalidDigitRepititions).noneMatch(romanNumber::contains);
    }

    public static boolean isValidCombinations(String romanNumber) {
        return Arrays.stream(invalidDigitCombinations).noneMatch(romanNumber::contains);
    }

    private final int value;

    RomanDigit(int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }


}
