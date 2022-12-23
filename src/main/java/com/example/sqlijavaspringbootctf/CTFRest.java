package com.example.sqlijavaspringbootctf;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api")
public class CTFRest {

    private final JdbcTemplate jdbcTemplate;

    public CTFRest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to this API as part of a CTF Challenge";
    }

    @GetMapping("/execute/{sql}")
    public List<Map<String, Object>> executeAnySQL(@PathVariable String sql) {
        return jdbcTemplate.queryForList(sql);
    }
}
