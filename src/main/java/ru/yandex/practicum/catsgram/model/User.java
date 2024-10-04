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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
