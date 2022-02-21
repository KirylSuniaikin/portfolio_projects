package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//значит что впереди назодиться главный класс для запуска springBoot приложения
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
