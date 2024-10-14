package ru.yandex.practicum.catsgram.service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.model.Post;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service // делает тоже самое, что и @Component, только для класса с логикой
@Slf4j
public class PostService {

    private final List<Post> posts = new ArrayList<>();

    public List<Post> findAll(int size, int from){
        log.info("Получить {} постов, начиная с {}", size, from);
        return posts.stream()
                .sorted(Comparator.comparing(Post::getId)) // сортировка по возрастанию
                .filter(x -> x.getId() >= from)
                .limit(size)
                .toList();
    }

    public Optional<Post> findById(int postId){
        log.info("Получен пост с id {}", postId);
        return posts.stream()
                .filter(x -> x.getId() == postId)
                .findFirst();
    }


    public Post create(Post post){
        log.info("Добавлен пост: {}", post);
        posts.add(post);
        return post;
    }
}
