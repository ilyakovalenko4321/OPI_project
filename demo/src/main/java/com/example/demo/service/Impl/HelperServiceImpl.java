package com.example.demo.service.Impl;

import com.example.demo.service.HelperService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Service
public class HelperServiceImpl implements HelperService {
    private  final Map<String, Runnable> commands = new HashMap<>();

    public HelperServiceImpl() {
        commands.put("/help", this ::help);
        commands.put("/clear", this::clear);
        commands.put("/exit", () -> System.out.println("Выход из программы..."));
        commands.put("/rules", this::rules);
    }

    @Override
    public void help() {
        System.out.println("Доступные команды:");
        for (String command : commands.keySet()) {
            System.out.println(" - " + command);
        }
    }

    @Override
    public void clear() {
        System.out.println("\\033[H\\033[2J");
        System.out.flush();
    }

    @Override
    public void rules() {
        System.out.println("Правила игры 'Быки и коровы':");
        System.out.println("1. Игра проводится между двумя игроками.");
        System.out.println("2. Один игрок загадывает 4-значное число, которое игроки должны отгадать.");
        System.out.println("3. Каждый раз, когда игрок делает попытку, система сообщает количество быков и коров.");
        System.out.println("   - 'Бык' означает, что цифра в вашей попытке стоит на своем месте.");
        System.out.println("   - 'Корова' означает, что цифра есть в загаданном числе, но она стоит не на своем месте.");
        System.out.println("4. Игроки продолжают делать попытки, пока не отгадают все цифры.");
        System.out.println("5. Побеждает тот игрок, который первым угадает загаданное число.");
    }

    @Override
    public void commandChoicer() {
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Добро пожаловать! Введите /help для списка доступных команд");
        while(true) {
            System.out.print(" > ");
            input = scanner.nextLine();

            Runnable command = commands.get(input);
            if (command != null) {
                command.run();
                if (input.equals("/exit")) break;
            } else {
                System.out.println("Неизвестная команда. Введите /help еще раз");
            }
        }
        scanner.close();
    }
}
