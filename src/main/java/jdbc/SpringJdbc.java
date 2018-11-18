//TODO:
//Use DriverManagerDataSource,dbcp2.BasicDataSource and
// SingleConnectionDataSource to get Database connection

package jdbc;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SpringJdbc {

    private DataSource dataSource;

    public SpringJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void preparedStatement() throws Exception {

        PreparedStatement ps = dataSource.getConnection().prepareStatement("select * from user");

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {

            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(4));
            System.out.println(resultSet.getString(5));

        }

    }

}
