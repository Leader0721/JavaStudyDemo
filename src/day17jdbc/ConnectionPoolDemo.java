package day17jdbc;

import day15jdbc01.utils.JDBCUtils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * 模拟数据库连接池的原理
 * Created by 83731 on 2017/09/20.
 */
public class ConnectionPoolDemo {
    private static List<Connection> pool = new ArrayList<>();

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
    public synchronized static Connection getConnection() {
        if (pool.size() > 0) {
            Connection connection = pool.remove(0);
            return connection;
        } else {
            throw new RuntimeException("服务器真忙");

        }
    }


    //把链接还回池中
    public static void release(Connection connection) {
        pool.add(connection);
    }

}
