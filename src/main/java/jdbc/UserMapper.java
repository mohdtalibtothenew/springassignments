package jdbc;

import jdbc.domain.User;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUserName(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setAge(rs.getInt("age"));
        user.setSalary(rs.getDouble("salary"));
        user.setDob(rs.getDate("dob"));
        return user;
    }

}
