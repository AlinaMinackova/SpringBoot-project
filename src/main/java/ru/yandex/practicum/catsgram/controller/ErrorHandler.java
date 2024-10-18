package ru.yandex.practicum.catsgram.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.exception.UserNotFoundException;

import java.util.Map;

@RestControllerAdvice("ru.yandex.practicum.catsgram.controller")
//нужно для обозначения обработки ответов с ошибками
//в параметре передаем пакет, из которого будут перехватываться ошибки
//можно указать конкретный класс
public class ErrorHandler {

    @ExceptionHandler({UserAlreadyExistException.class, InvalidEmailException.class, UserNotFoundException.class})
    //перехватывает ошибку и отправляет сообщение понятное для пользователя
    @ResponseStatus(HttpStatus.BAD_REQUEST) //если не пометить метод такой аннотацией, то
    //даже при ответе с ошибкой статус будет 200, а теперь 400
    public Map<String, String> handleException(RuntimeException exception) {
        return Map.of("error", exception.getMessage());
        //также можно использовать уже реализованную ошибку ответа
        //return new ResponseStatusException(HttpStatus.BAD_REQUEST, "описание ошибки");
        // и в application.properties написать server.error.include-message=always
        //убрать @ResponseStatus(HttpStatus.BAD_REQUEST) над методом
        //возвращаемый тип будет ResponseStatusException
        //чтобы отобразить переданное сообщение
        // ответ будет{
        //    "type": "about:blank",
        //    "title": "Bad Request",
        //    "status": 400,
        //    "detail": "описание ошибки",
        //    "instance": "/users"
        //}
        //ниже пример
    }
//
//    @ExceptionHandler({UserAlreadyExistException.class, InvalidEmailException.class})
//    public ResponseStatusException handleException2(RuntimeException exception) {
//        return new ResponseStatusException(HttpStatus.BAD_REQUEST, "описание ошибки");
//    }
}
