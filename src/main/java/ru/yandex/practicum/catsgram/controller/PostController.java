package ru.yandex.practicum.catsgram.controller;

import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.service.PostService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController //также десериализует из класса в json формат
//если класс помечен @RestController, то @ResponseBody добавляется к каждому методу класса
//@ResponseBody также десериализует из класса в json формат, как и @RestController, только применяется для метода
@Slf4j
public class PostController {

    private final PostService postService; //класс сервиса

    @Autowired // класс PostService зависимость
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public Collection<Post> findAll(@RequestParam(value="size", defaultValue="10") String size,
                              @RequestParam(value="sort", defaultValue="asc") String sort){
        // @RequestParam - параметр запроса (автор=Том)
        // @RequestParam(value="size", defaultValue="10") - значение по умолчанию
        return postService.findAll(Integer.parseInt(size), sort); // вызывает метод зависимости;
    }

    @GetMapping("/posts/author")
    public Collection<Post> findAllByAuthor(@RequestParam String author_id){
        System.out.println("пример работы с параметрами запроса");
        return postService.findAllByUser(author_id);
    }
}
//
//    @GetMapping("/posts/{postId}")
//    public Optional<Post> findById(@PathVariable int postId){ //@PathVariable - переменная пути
//        // принять значение из пути (имена совпадают!)
//        return postService.findById(postId);
//    }
//
//    @GetMapping("/posts/{author}/search")
//    public void findByListAuthor(
//            @PathVariable int author, //@PathVariable - переменная пути
//            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate from,
//            // @RequestParam - параметр запроса (автор=Том)
//            //@DateTimeFormat сразу преобразовать в дату
//            @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate to
//    ){
//        System.out.println("пример работы с параметрами запроса");
//    }


