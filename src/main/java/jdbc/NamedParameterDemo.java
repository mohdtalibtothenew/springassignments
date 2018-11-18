package jdbc;

import jdbc.domain.User;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class NamedParameterDemo {
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public NamedParameterDemo(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    public User namedParameterJdbcTemplateDemo() {
        String sql = "SELECT * FROM user WHERE username = :name";
        SqlParameterSource parameterSource = new MapSqlParameterSource("name", "manisha");
        return namedParameterJdbcTemplate.queryForObject(sql, parameterSource, new UserMapper());
    }
}
