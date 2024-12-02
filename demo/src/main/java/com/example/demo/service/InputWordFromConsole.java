package com.example.demo.service;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static com.example.demo.service.InputCheck.checkLanguage;

public class InputWordFromConsole {

    private static final Scanner scan = new Scanner(System.in);

    public static String inputWordFromConsole() {
        String inputWord = "";
        boolean isInCorrect;
        do {
            isInCorrect = true;
            try {
                inputWord = scan.nextLine();
            }
            catch (NoSuchElementException e) {
                isInCorrect = false;
                System.out.println("Incorrect.");
            }
            isInCorrect = checkLanguage(inputWord);
        } while (!isInCorrect);
        return inputWord;
    }


}
