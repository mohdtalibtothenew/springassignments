package jdbc;

import jdbc.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomJDBCTemplate {
    private JdbcTemplate jdbcTemplate;

    public CustomJDBCTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //TODO:Use JdbcTemplate to get the  count of users
    public void countUser() {
        String sql = "SELECT COUNT(*) FROM user";
        System.out.println(jdbcTemplate.queryForObject(sql, Integer.class));
    }


    //TODO: Get the name of the user by using parametrized query
    public String getUserName() {

        String sql = "SELECT username FROM user WHERE id= ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{"1"}, String.class);

    }

    //TODO:Insert record in user table using jdbcTemplate
    public void addUser(User user) {
        String sql = "INSERT INTO user (id,username,password,age,salary,date)VALUES(?,?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{user.getId(), user.getUserName(), user.getPassword(),
                user.getAge(), user.getSalary(), user.getDob()});
    }


    //TODO:Use queryForMap of JdbcTemplate to fetch the  details of user table
    public void queryForMapDemo() {

        String sql = "SELECT * FROM user WHERE id=?";
        System.out.println(jdbcTemplate.queryForMap(sql,new Object[]{"1"}));

    }

    //TODO:Use queryForList of JdbcTemplate to fetch all the records of user table
    public void queryForListDemo(){
        String sql = "SELECT * FROM user";
        System.out.println(jdbcTemplate.queryForList(sql));
    }

    //TODO:Use RowMapper to get the User Object
    public User getUser() {
        String sql = "SELECT * FROM user WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{"1"}, new UserMapper());
    }
}
