package ru.yandex.practicum.catsgram.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.catsgram.dao.FollowDao;
import ru.yandex.practicum.catsgram.dao.PostDao;
import ru.yandex.practicum.catsgram.model.Post;

import java.util.List;

@Service // делает тоже самое, что и @Component, только для класса с логикой
@Slf4j
public class FollowService {

    private final FollowDao followDao;

    @Autowired

    public FollowService(FollowDao followDao) {
        this.followDao = followDao;
    }

    public List<Post> findPostFriends(String follow_id, int size){
        return followDao.getFollowFeed(follow_id, size);
    }

}
