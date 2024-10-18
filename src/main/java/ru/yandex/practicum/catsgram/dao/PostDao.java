package ru.yandex.practicum.catsgram.dao;

import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.model.User;

import java.util.Collection;
import java.util.Optional;

public interface PostDao {

    Collection<Post> findAllByUser(User user);
    Collection<Post> findAll(Integer size, String sort, Collection<User> users);
}
