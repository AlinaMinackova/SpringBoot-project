package ru.yandex.practicum.catsgram.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

//lombok
@ToString
@Getter
@Setter
public class User {

    private String email;
    private String nickname;
    private LocalDate birthdate;

    public User(String email, String nickname, LocalDate birthdate) {
        this.email = email;
        this.nickname = nickname;
        this.birthdate = birthdate;
    }

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
