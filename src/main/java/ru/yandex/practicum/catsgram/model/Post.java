package ru.yandex.practicum.catsgram.model;

import lombok.*;

import javax.management.ConstructorParameters;
import java.time.Instant;
import java.time.LocalDate;

//lombok
//@Data - создать все пять аннотаций только конструктор
// будет @RequiredArgsConstructor, который добавляет только final поля
@Data
public class Post{

    private Integer id;
    private final User author;
    private final LocalDate creationDate;
    private String description;
    private String photoUrl;

    public Post(User author, String description, String photoUrl) {
        this.author = author;
        this.description = description;
        this.photoUrl = photoUrl;
        this.creationDate = LocalDate.now();
    }

    public Post(Integer id, User author, LocalDate creationDate, String description, String photoUrl) {
        this.id = id;
        this.author = author;
        this.creationDate = creationDate;
        this.description = description;
        this.photoUrl = photoUrl;
    }
}
