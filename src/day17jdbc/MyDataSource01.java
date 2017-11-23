package day17jdbc;

import day15jdbc01.utils.JDBCUtils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by 83731 on 2017/09/20.
 */
public class MyDataSource01 implements DataSource {

    //线程安全的
    private static List<Connection> pool = Collections.synchronizedList(new ArrayList<Connection>());

    static {
        for (int i = 0; i < 10; i++) {
            try {
                Connection connection = null;//这个是创建新的链接
                connection = JDBCUtils.getConnection();
                pool.add(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    //从池中取出一个链接
    //进行同步
    public Connection getConnection() throws SQLException {
        if (pool.size() > 0) {
            Connection connection = pool.remove(0);
            return connection;
        } else {
            throw new RuntimeException("服务器真忙");

        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
