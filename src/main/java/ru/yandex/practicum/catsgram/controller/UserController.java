package ru.yandex.practicum.catsgram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;
import ru.yandex.practicum.catsgram.service.PostService;
import ru.yandex.practicum.catsgram.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private HashMap<String, User> users = new HashMap<>();

    private final UserService userService; //класс сервиса

    @Autowired // класс UserService зависимость
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public HashMap<String, User> findAll(){
        return userService.findAll();
    }

    @PostMapping(value = "")
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping("")
    public User update(@RequestBody User user){
        return userService.update(user);
    }
}
