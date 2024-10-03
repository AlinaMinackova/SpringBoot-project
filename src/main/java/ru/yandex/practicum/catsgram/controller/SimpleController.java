package ru.yandex.practicum.catsgram.controller;

import org.springframework.web.bind.annotation.*;


//класс для создания эндпоинтов
@RestController // Spring понимает, что класс содержит методы для обработки эндпоинтов
//@RequestMapping("/api/") //перейдем по этому адресу в этот класс
public class SimpleController {

    //@RequestMapping(value = "/home", method = RequestMethod.GET) раньше
    //GETMapping("/home") сейчас
    @GetMapping("/home") // дальше по этому продолжению в этот метод
    public String homePage() {
        return "Catsgram";
    }
}
