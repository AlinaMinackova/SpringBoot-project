package ru.yandex.practicum.catsgram.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.controller.UserController;
import ru.yandex.practicum.catsgram.dao.UserDao;
import ru.yandex.practicum.catsgram.exception.InvalidEmailException;
import ru.yandex.practicum.catsgram.model.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service // делает тоже самое, что и @Component, только для класса с логикой
public class UserService {

    private static final Logger log  = LoggerFactory.getLogger(UserController.class);

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }


    public User findByEmail(String email){
        log.info("Получен пользователь с email: {}", email);
        return userDao.findByEmail(email);
    }


    public List<User> findAll(){
        return userDao.findAll();
    }

    public User create(User user){
        if (user.getEmail().equals("") || user.getEmail() == null){
            throw new InvalidEmailException("InvalidEmailException");
        }
        userDao.create(user);
        return user;
    }

    public User update(User user){
        if (user.getEmail() == null || user.getEmail().equals("")){
            throw new InvalidEmailException("InvalidEmailException");
        }
        return userDao.update(user);
    }
}
