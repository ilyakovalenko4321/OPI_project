package com.example.demo;

import com.example.demo.service.InputWordFromConsole;

import java.util.Scanner;

import static com.example.demo.repository.FileReader.randomWordGenerator;
import static com.example.demo.service.InputCheck.checkLanguage;
import static com.example.demo.service.InputCheck.checkWord;
import static com.example.demo.service.WorkingFile.checkingCAndB;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Быки и коровы.");
        int[] cAdnB = new int[2];
        String randStr = randomWordGenerator();
        while (true) {
            String userStr = InputWordFromConsole.inputWordFromConsole();
            if (checkLanguage(userStr) && checkWord(userStr, randStr.length()))
                cAdnB = checkingCAndB(randStr, userStr);
            if (cAdnB[0] == randStr.length())
                break;
        }
    }
}
