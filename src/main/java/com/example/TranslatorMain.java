package com.example;

import com.example.controller.TranslatorController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TranslatorMain {
    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get("inputs.txt"))){
            lines
                    .filter(line -> !line.isEmpty())
                    .forEach(TranslatorController::parse);
            TranslatorController.printAnswers();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
