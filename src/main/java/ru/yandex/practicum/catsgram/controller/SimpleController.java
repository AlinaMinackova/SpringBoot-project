package ru.yandex.practicum.catsgram.controller;

import org.springframework.web.bind.annotation.*;


//класс для создания эндпоинтов
@RestController // Spring понимает, что класс содержит методы для обработки эндпоинтов
public class SimpleController {

    @RequestMapping("/home")
    public String homePage() {
        return "Catsgram";
    }
}
