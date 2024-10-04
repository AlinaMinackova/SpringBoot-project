package ru.yandex.practicum.catsgram.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger log  = LoggerFactory.getLogger(UserController.class);

    private HashMap<String, User> users = new HashMap<>();

    @GetMapping("")
    public HashMap<String, User> findAll(){
        log.info("Количество пользователей: {}", users.size());
        return users;
    }

    @PostMapping(value = "")
    public User create(@RequestBody User user){
        if (user.getEmail().equals("") || user.getEmail() == null){
            throw new InvalidEmailException("InvalidEmailException");
        }
        if (!users.containsKey(user.getEmail())) {
            log.info("Добавлен пользователь: {}", user);
            users.put(user.getEmail(), user);
            return user;
        }
        else {
            throw new UserAlreadyExistException("UserAlreadyExistException");
        }
    }

    @PutMapping("")
    public User update(@RequestBody User user){
        if (user.getEmail() == null || user.getEmail().equals("")){
            throw new InvalidEmailException("InvalidEmailException");
        }
        if (!users.containsKey(user.getEmail())) {
            users.put(user.getEmail(), user);
        } else {
            User user1 = users.get(user.getEmail());
            user1.setBirthdate(user.getBirthdate());
            user1.setNickname(user.getNickname());
        }
        return user;
    }
}
