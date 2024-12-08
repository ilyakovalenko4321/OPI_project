package com.example.demo.service.Impl;

import com.example.demo.domain.WordEntity;
import com.example.demo.service.GameCowsLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class GameCowsLogicServiceImpl implements GameCowsLogicService {

    private final WordServiceImpl wordService;

    public int play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вы играете в игру быки-коровы.\n /*Пересказ логики*/");
        System.out.println("Введите длину слова");
        Integer wordLength;
        while (true) {
            try {
                wordLength = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Вы должны ввести число от 0 до 255");
            }
        }
        scanner.nextLine();

        WordEntity programWord = wordService.wordChooser(wordLength);

        while (true) {
            System.out.println("Введите слово");
            String userWord = scanner.nextLine();
            try {
                wordService.wordValidation(userWord);
                if (!isValid(userWord, wordLength)) {
                    throw new RuntimeException();
                }
                if (userWord.equalsIgnoreCase("/exit")) {
                    return -1;
                }
                int[] resultArray = getBullsCOws(userWord, programWord.getWord());
                if (!Arrays.equals(resultArray, new int[]{4, 4})) {
                    continue;
                }
                System.out.println("Вы победили!");
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                //scanner.nextLine();
            }
        }
        return 1;
    }

    private int[] getBullsCOws(String input, String word) {
        int[] cAndB = new int[2];
        if (word.equals(input)) {
            System.out.println("Победа.");
            cAndB[0] = 4;
            cAndB[1] = 4;
        } else {
            for (int i = 0; i < input.length(); i++) {
                if (word.charAt(i) == input.charAt(i)) cAndB[0]++;
                for (int j = 0; j < word.length(); j++) {
                    if (input.charAt(i) == word.charAt(j)) {
                        cAndB[1]++;
                        break;
                    }
                }

            }
        }
        System.out.println("Быки: " + cAndB[1] + ", Коровы: " + cAndB[0]);
        return cAndB;
    }

    private boolean isValid(String word, Integer length) {
        return word.length() == length;
    }

}
