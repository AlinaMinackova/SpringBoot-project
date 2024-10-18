package ru.yandex.practicum.catsgram.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.dao.PostDao;
import ru.yandex.practicum.catsgram.exception.UserNotFoundException;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.model.User;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

@Service // делает тоже самое, что и @Component, только для класса с логикой
@Slf4j
public class PostService {


    private final PostDao postDao;
    private final UserService userService;

    @Autowired
    public PostService(PostDao postDao, UserService userService) {
        this.postDao = postDao;
        this.userService = userService;
    }

        public Collection<Post> findAll(int size, String sort){
        log.info("Получить {} постов", size);
        return postDao.findAll(size, sort, userService.findAll());
    }

    public Collection<Post> findAllByUser(String userId){
        User user = userService.findByEmail(userId).orElseThrow(() -> new UserNotFoundException("пользователь с данным id не найден"));
        log.info("Получен пост от пользователя {}", userId);
        return postDao.findAllByUser(user);
    }
}
