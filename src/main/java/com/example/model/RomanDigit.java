package com.example.model;

public enum RomanDigit {
    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500),
    M(1000);

    private final int value;

    RomanDigit(int newValue) {
        value = newValue;
    }

    public int getValue() {
        return value;
    }



}
