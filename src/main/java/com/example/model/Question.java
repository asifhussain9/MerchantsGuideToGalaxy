package com.example.model;

import com.sun.istack.internal.NotNull;

import java.util.Collections;
import java.util.List;

public class Question {
    private List<String> intergalacticNumber;
    private String ornament;

    public Question(@NotNull List<String> intergalacticNumber, @NotNull String ornament) {
        this.intergalacticNumber = intergalacticNumber == null ? Collections.emptyList() : intergalacticNumber;
        this.ornament = ornament == null ? "" : ornament;
    }

    public String getOrnament() {
        return ornament;
    }

    public List<String> getIntergalacticNumber() {
        return intergalacticNumber;
    }
}
