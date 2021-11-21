package com.zaripov.boot.joke;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JdbcJokeDataService implements JokeDataService {

    private final JdbcTemplate jdbcTemplate;

    public JdbcJokeDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(String joke) {
        jdbcTemplate.update("insert into jokes (joke) values(?)", joke);
    }

    @Override
    public List<String> getAll() {
        return jdbcTemplate.query("select joke from jokes",(rs, rowNum) -> rs.getString("joke"));
    }
}