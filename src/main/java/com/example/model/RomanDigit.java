package com.example.model;

import java.util.Arrays;
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
    public static final String[] digitRepititionValidation = {NON_REPEATABLE_D, NON_REPEATABLE_L, NON_REPEATABLE_V, REPEATABLE_C, REPEATABLE_I, REPEATABLE_X, REPEATABLE_M};

    static {
        subtractionPatternValueMap = new HashMap<>();
        subtractionPatternValueMap.put("IV", 4D);
        subtractionPatternValueMap.put("IX", 9D);
        subtractionPatternValueMap.put("XL", 40D);
        subtractionPatternValueMap.put("XC", 90D);
        subtractionPatternValueMap.put("CD", 400D);
        subtractionPatternValueMap.put("CM", 900D);
    }

    public static boolean isValidRepititions(String romanNumber) {
        boolean isValid = true;

        isValid = !Arrays.stream(digitRepititionValidation).anyMatch(
                validationRule -> romanNumber.contains(validationRule)
        );

        return isValid;
    }

    private final int value;

    RomanDigit(int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }


}
