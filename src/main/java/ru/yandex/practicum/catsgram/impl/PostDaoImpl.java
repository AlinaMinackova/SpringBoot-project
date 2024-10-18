package ru.yandex.practicum.catsgram.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.catsgram.dao.PostDao;
import ru.yandex.practicum.catsgram.dao.UserDao;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

@Component
public class PostDaoImpl implements PostDao {


    private final JdbcTemplate jdbcTemplate;

    public PostDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Collection<Post> findAllByUser(User user) {
        String sql = "select * from cat_post where author = ? order by create_date desc";
        return jdbcTemplate.query(sql, (rs, rowNum) -> makePost(rs, user), user.getEmail());
    }

    @Override
    public Collection<Post> findAll(Integer size, String sort, Collection<User> users) {
        String sql = "select * from cat_post order by create_date " + sort + " limit " + size;
        return jdbcTemplate.query(sql, new RowMapper<Post>() {
            @Override
            public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
                Integer id = Integer.valueOf(rs.getString("id"));
                LocalDate create_date = LocalDate.parse(rs.getString("create_date"));
                String description = rs.getString("description");
                String photo = rs.getString("photo");
                String email = rs.getString("author");
                User user = users.stream().filter(x -> x.getEmail().equals(email)).toList().get(0);
                return new Post(id, user, create_date, description, photo);
            }});
    }

    public Post makePost(ResultSet rs, User user) throws SQLException {
        Integer id = Integer.valueOf(rs.getString("id"));
        LocalDate create_date = LocalDate.parse(rs.getString("create_date"));
        String description = rs.getString("description");
        String photo = rs.getString("photo");
        return new Post(id, user, create_date, description, photo);
    }
}
