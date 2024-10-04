package ru.yandex.practicum.catsgram.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

//lombok
//@Data - создать все пять аннотаций только конструктор
// будет @RequiredArgsConstructor, который добавляет только final поля

//класс для создания эндпоинтов
@RestController // Spring понимает, что класс содержит методы для обработки эндпоинтов
//@RequestMapping("/api/") //перейдем по этому адресу в этот класс
@Slf4j //создаем логер
public class SimpleController {

    //@RequestMapping(value = "/home", method = RequestMethod.GET) раньше
    //GETMapping("/home") сейчас
    @GetMapping("/home") // дальше по этому продолжению в этот метод
    public String homePage() {

        //логируем факт получения запроса
        log.debug("Запрос получен.");
        return "Catsgram";
    }
}
