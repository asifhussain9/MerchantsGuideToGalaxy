package com.example;

import com.example.controller.TranslatorController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Please use the inputs.txt file to give inputs to the file
 * This is the main class that reads input from inputs.txt and prints output to console
 *
 * @author Asif Hussain
 * @version 1.0
 *
 */
public class TranslatorMain {
    public static void main(String[] args) {
        if (!Files.exists(Paths.get("inputs.txt"))) {
            System.out.println("Please provide a valid input file");
            return;
        }

        try (Stream<String> lines = Files.lines(Paths.get("inputs.txt"))) {
            lines
                    .filter(line -> !line.isEmpty())
                    .forEach(TranslatorController::parse);
            TranslatorController.printAnswers();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
