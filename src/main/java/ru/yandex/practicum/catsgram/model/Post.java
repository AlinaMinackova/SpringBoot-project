package ru.yandex.practicum.catsgram.model;

import lombok.*;

import javax.management.ConstructorParameters;
import java.time.Instant;

//lombok
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Post {

    private final String author;
    private final Instant creationDate = Instant.now();
    private String description;
    private String photoUrl;


}
