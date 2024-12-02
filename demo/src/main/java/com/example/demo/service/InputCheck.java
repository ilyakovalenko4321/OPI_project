package com.example.demo.service;

import java.util.Scanner;

public class InputCheck {


    public static boolean checkLanguage(String word) {

        boolean isInCorrect = true;
        int temp1, temp2;
        String rusalphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        temp1 = word.length();
        temp2 = rusalphabet.length();
        for (char character: word.toCharArray()) {
            if (!rusalphabet.contains(Character.toString(character))) {
                isInCorrect = false;
                break;
            }
        }
        return isInCorrect;
    }

    public static boolean checkWord(final String word, final int num) {
        boolean isCorrect;
        isCorrect = true;
        if (word.length() > num || word.isEmpty()) {
            isCorrect = false;
            System.err.println("Ошибка! Длина слова некорректна!");
        }
        return isCorrect;
    }

    public static int getNum() {
        Scanner scan = new Scanner(System.in);

        final int min = 2, max = 10;
        int num;
        boolean isCorrect;
        num = 0;
        do {
            isCorrect = true;
            try {
                num = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Ошибка! Некорректный ввод!");
                isCorrect = false;
            }
            if (isCorrect && ((num > 10) || (num < 2))) {
                System.err.println("Ошибка! Невозможный вариант!");
                isCorrect = false;
            }
        } while (!isCorrect);
        return num;
    }


}
