package ru.yandex.practicum.catsgram.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.Post;

import java.util.List;

@RestController
@Slf4j
public class PostFeedController {

//    @PostMapping("/feed/friends")
//    public List<Post> findAll(@RequestBody String post) throws JsonProcessingException {
//        Post postFromJson = new ObjectMapper().readValue(post, Post.class);
//        System.out.println(body);
//    }
}
