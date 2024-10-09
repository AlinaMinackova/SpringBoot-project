package ru.yandex.practicum.catsgram.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.yandex.practicum.catsgram.controller.UserController;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.exception.UserAlreadyExistException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.HashMap;

@Service // делает тоже самое, что и @Component, только для класса с логикой
public class UserService {

    private static final Logger log  = LoggerFactory.getLogger(UserController.class);

    private HashMap<String, User> users = new HashMap<>();

    public HashMap<String, User> findAll(){
        log.info("Количество пользователей: {}", users.size());
        return users;
    }

    public User create(User user){
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

    public User update(User user){
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
