package com.example.demo.javaScripts;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BookCleaner {

    public static void main(String[] args) {
        // Указываем пути к файлам
        String inputFilePath = "C:\\Work\\WarAndPeace\\Tolstoy Leo. War and Peace - royallib.com.txt"; // Путь к файлу книги "Война и мир"
        String outputFilePath = "C:\\Work\\WarAndPeace\\Tolstoy Leo. War and Peace - royallibNEW.com.txt"; // Путь к файлу для сохранения результата

        try {
            // Чтение исходного файла
            String content = readFile(inputFilePath);

            // Очистка текста, оставляем только слова и пробелы
            String cleanedContent = cleanText(content);

            // Запись очищенного текста в новый файл
            writeFile(outputFilePath, cleanedContent);

            System.out.println("Файл успешно очищен и сохранен!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для чтения файла
    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    // Метод для очистки текста (удаляем все символы, кроме пробела и букв)
    public static String cleanText(String text) {
        return text.replaceAll("[^\\p{L}\\s]", " ");  // Заменяем все символы, кроме букв и пробела
    }

    // Метод для записи очищенного текста в новый файл
    public static void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), StandardCharsets.UTF_8))) {
            writer.write(content);
        }
    }
}
