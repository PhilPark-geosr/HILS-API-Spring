package ppark.springppark.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/jdbc")
public class JdbcKcgNonshipAccident {
    private final JdbcTemplate jdbcTemplate;

    public JdbcKcgNonshipAccident(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/KcgNonshipAccident")
    public List<String> getAllGeoEntitiesAsGeoJSON() {
        String query = "SELECT ST_AsGeoJSON(geometry) FROM characteristics_accidents.kcg_nonship_accidents";
        return jdbcTemplate.query(query, new GeoJSONRowMapper());
    }

    private static class GeoJSONRowMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getString(1);
        }
    }
}
