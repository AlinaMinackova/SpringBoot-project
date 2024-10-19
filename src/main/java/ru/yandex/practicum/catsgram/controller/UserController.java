package ru.yandex.practicum.catsgram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;
import ru.yandex.practicum.catsgram.service.PostService;
import ru.yandex.practicum.catsgram.service.UserService;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService; //класс сервиса

    @Autowired // класс UserService зависимость
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{email}")
    public User findByEmail(@PathVariable String email){
        //@PathVariable - переменная пути
        // принять значение из пути (имена совпадают!)
        return userService.findByEmail(email);
    }

    @PostMapping(value = "")
    public User create(@RequestBody User user){ //@RequestBody принять значение из body
        return userService.create(user);
    }

    @PutMapping("")
    public User update(@RequestBody User user){
        return userService.update(user);
    }
}
