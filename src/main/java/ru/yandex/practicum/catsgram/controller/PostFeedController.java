package ru.yandex.practicum.catsgram.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.service.FollowService;
import ru.yandex.practicum.catsgram.service.PostService;

import java.util.List;

@RestController
@Slf4j
public class PostFeedController {

    private final FollowService followService; //класс сервиса

    @Autowired
    public PostFeedController(FollowService followService) {
        this.followService = followService;
    }


    @GetMapping("/feed/friends/{follow_id}")
    public List<Post> findAllPosts(@PathVariable String follow_id, @RequestParam(value="size", defaultValue="5") String size) {
        return followService.findPostFriends(follow_id, Integer.parseInt(size));
    }
}
