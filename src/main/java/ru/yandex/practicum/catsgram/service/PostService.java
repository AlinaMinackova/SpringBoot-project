package ru.yandex.practicum.catsgram.service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.model.Post;

import java.util.ArrayList;
import java.util.List;

@Service // делает тоже самое, что и @Component, только для класса с логикой
@Slf4j
public class PostService {

    private List<Post> posts = new ArrayList<>();

    public List<Post> findAll(){
        log.info("Количество постов: {}", posts.size());
        return posts;
    }

    public Post create(Post post){
        log.info("Добавлен пост: {}", post);
        posts.add(post);
        return post;
    }
}
