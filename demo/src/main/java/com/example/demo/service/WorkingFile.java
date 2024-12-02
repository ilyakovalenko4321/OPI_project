package com.example.demo.service;

public class WorkingFile {

    public static int[] checkingCAndB(String word, String input)
    {
        int[] cAndB = new int[2];
        if (word.equals(input))
        {
            System.out.println("Победа.");
            cAndB[0] = 4;
            cAndB[1] = 4;
        }
        else
        {
            for (int i = 0; i < input.length(); i++)
            {
                if (word.charAt(i) == input.charAt(i))
                    cAndB[0]++;
                for (int j = 0; j < word.length(); j++)
                {
                    if(input.charAt(i) == word.charAt(j))
                    {
                        cAndB[1]++;
                        break;
                    }
                }

            }
        }
        System.out.println("Быки: " + cAndB[1] + "\nКоровы: " + cAndB[0]);
        return cAndB;
    }


}
