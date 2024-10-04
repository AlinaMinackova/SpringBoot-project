package ru.yandex.practicum.catsgram.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

//lombok
@ToString
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class User {

    private String email;
    @EqualsAndHashCode.Exclude // исключить это поля для equals и hashcode
    private String nickname;
    @EqualsAndHashCode.Exclude
    private LocalDate birthdate;
}
