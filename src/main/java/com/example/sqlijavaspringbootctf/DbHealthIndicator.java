package com.example.sqlijavaspringbootctf;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DbHealthIndicator implements HealthIndicator {
    private final JdbcTemplate jdbcTemplate;

    public DbHealthIndicator(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Health health() {
        List<Map<String, Object>> showTablesFromPublic = jdbcTemplate.queryForList("SHOW tables FROM PUBLIC");
        if (showTablesFromPublic.isEmpty()){
            return Health.down().build();
        }
        return Health.up().build();
    }
}
