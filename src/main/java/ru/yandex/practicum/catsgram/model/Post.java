package ru.yandex.practicum.catsgram.model;

import lombok.*;

import javax.management.ConstructorParameters;
import java.time.Instant;

//lombok
//@Data - создать все пять аннотаций только конструктор
// будет @RequiredArgsConstructor, который добавляет только final поля
@Data
@AllArgsConstructor
public class Post {

    private Integer id;
    private final String author;
    private final Instant creationDate = Instant.now();
    private String description;
    private String photoUrl;


}
