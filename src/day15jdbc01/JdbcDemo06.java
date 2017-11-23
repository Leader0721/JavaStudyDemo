package day15jdbc01;

import day15jdbc01.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by 83731 on 2017/09/17.
 */
public class JdbcDemo06 {
    @Test
    public void testAdd() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate("insert into users(name,password,email,birthday) values('冉闵','123','24234.@23.com','2011-02-22')");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.release(resultSet, statement, connection);
        }
    }

    @Test
    public void testUpdate() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate("update users set password=222222 where id = 4 ");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.release(resultSet, statement, connection);
        }
    }

    @Test
    public void testDelete() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate("delete from users where id = 4 ");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.release(resultSet, statement, connection);
        }
    }
}
