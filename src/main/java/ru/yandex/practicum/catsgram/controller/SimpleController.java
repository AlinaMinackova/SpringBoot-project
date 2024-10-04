package ru.yandex.practicum.catsgram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;



//класс для создания эндпоинтов
@RestController // Spring понимает, что класс содержит методы для обработки эндпоинтов
//@RequestMapping("/api/") //перейдем по этому адресу в этот класс
public class SimpleController {

    //создаем логер
    private static final Logger log  = LoggerFactory.getLogger(SimpleController.class);

    //@RequestMapping(value = "/home", method = RequestMethod.GET) раньше
    //GETMapping("/home") сейчас
    @GetMapping("/home") // дальше по этому продолжению в этот метод
    public String homePage() {

        //логируем факт получения запроса
        log.debug("Запрос получен.");
        return "Catsgram";
    }
}
