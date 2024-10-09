package ru.yandex.practicum.catsgram.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.service.PostService;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class PostController {

    private final PostService postService; //класс сервиса

    @Autowired // класс PostService зависимость
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> findAll(){
        return postService.findAll(); // вызывает метод зависимости
    }

    @PostMapping(value = "/post")
    public Post create(@RequestBody Post post){
        return postService.create(post); // вызывает метод зависимости
    }
}
