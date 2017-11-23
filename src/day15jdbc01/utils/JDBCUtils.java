package day15jdbc01.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by 83731 on 2017/09/17.
 */
public class JDBCUtils {
    private static String driverClass;
    private static String url;
    private static String user;
    private static String password;

    //静态代码块是最先加载的  然后再加载方法
    static {
        try {
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            InputStream in = classLoader.getResourceAsStream("dbcfg.properties");
            Properties properties = new Properties();
            properties.load(in);
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            Class.forName(driverClass);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws Exception {
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    public static void release(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resultSet = null;
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement = null;
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }

}
