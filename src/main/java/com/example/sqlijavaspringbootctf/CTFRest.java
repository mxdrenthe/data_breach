package com.example.sqlijavaspringbootctf;

import org.springframework.beans.factory.annotation.Autowired;
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

    private JdbcTemplate jdbcTemplate;

    public CTFRest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to this API as part of a CTF Challenge their is an /api/execute HTTP GET endpoint also with a single parameter named sql";
    }

    @GetMapping("/execute/{sql}")
    public List<Map<String, Object>> executeAnySQL (@PathVariable String sql) {
        List<Map<String, Object>> resultList = null;

        resultList = jdbcTemplate.queryForList(sql);

        return resultList;
    }
}
