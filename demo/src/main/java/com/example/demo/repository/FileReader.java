package com.example.demo.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class FileReader {
    public static String randomWordGenerator() {
        File wordlistFile = new File("C:/test/wordlist.txt");
        Random randWordPos = new Random();
        int n = 2147483647, i = 0;
        String word = "яблоко";


        if (wordlistFile.isFile()) {
            if (wordlistFile.canRead()) {
                try (Scanner inputFile = new Scanner(wordlistFile)) {
                    for (i = 0; i < n; i++)
                        inputFile.nextLine();
                }
                catch (NoSuchElementException e) {
                    n = i;
                }
                catch (FileNotFoundException e) {
                    System.err.println("Файл по данному пути не существует!");
                }
            }
            else
                System.err.println("Файл по данному пути не может быть прочитан.");
        }
        else
            System.err.println("Файла по данному пути не существует.");

        if ((n == 0))
            System.err.println("Файл пуст, взято тестовое слово.");
        else {
            n = randWordPos.nextInt(n);
            try (Scanner inputFile = new Scanner(wordlistFile)) {
                for (i = 0; i < n; i++)
                    inputFile.nextLine();
                word = inputFile.nextLine();
            }
            catch (NoSuchElementException | FileNotFoundException ignored){}
        }

        return word;
    }

}
