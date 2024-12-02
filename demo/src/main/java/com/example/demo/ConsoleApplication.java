package com.example.demo;

import com.example.demo.service.Impl.GameCowsLogicServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ConsoleApplication implements CommandLineRunner {

    private final GameCowsLogicServiceImpl gameCowsLogicService;

    public static void main(String[] args) {
        SpringApplication.run(ConsoleApplication.class, args);
    }


    @Override
    public void run(String... args) {
        // Основная логика консольного приложения
        System.out.println("Приложение запущено!");
        // Например, вызов сервисов или обработка данных
        while(true){
            int result_code = gameCowsLogicService.play();
            if(result_code == -1){
                break;
            }
        }


    }
}
