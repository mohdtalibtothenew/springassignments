//TODO:Q-1)Use different connection mechanism to get Database connection
package jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Jdbcdemo {
    public static void main(String[] args) throws Exception {
        Jdbcdemo.preparedStatement();
    }

    private static Connection getConnection() throws Exception {
        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        String connection = "jdbc:mysql://localhost:3306/JdbcDemo";
        return DriverManager.getConnection(connection, "root", "igdefault");

    }


    private static Connection getConnection2() throws Exception {
        DriverManager.registerDriver(new Driver());
        String connectionString = "jdbc:mysql://localhost:3306/JdbcDemo";
        return DriverManager.getConnection(connectionString, "root", "igdefault");

    }


    private static Connection getConnection3() throws Exception {
        java.sql.Driver driver = new Driver();
        Properties dbProp = new Properties();
        dbProp.put("user", "root");
        dbProp.put("password", "igdefault");
        return driver.connect("jdbc:mysql://localhost:3306/JdbcDemo", dbProp);
    }


    private static Connection getConnection4() throws Exception {
        System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
        Properties dbProp = new Properties();
        dbProp.put("user", "root");
        dbProp.put("password", "igdefault");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/JdbcDemo", dbProp);
    }

    private static void preparedStatement() throws Exception {

        PreparedStatement ps = getConnection4().prepareStatement("select * from user");

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
