package day16jdbc;

import day15jdbc01.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * 批处理 降低与数据库的交互次数，提升执行效率
 * Created by 83731 on 2017/09/17.
 */
public class BatchDemo {

    /**
     * create table t1(
     * id int primary key,
     * name varchar(100));
     */
    //向数据库中插入2条数据  再把第一条删除掉
    //statement可以批处理语句不同的
    @Test
    public void test1() {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            Statement statement = connection.createStatement();
            String sql1 = "insert into t1 values(1,'1111')";
            String sql2 = "insert into t1 values(2,'2222')";
            String sql3 = "delete from t1 where id = 1";
            statement.addBatch(sql1);
            statement.addBatch(sql2);
            statement.addBatch(sql3);//Statement 实例的内部有一个list，sql语句增加到list中
            int[] ii = statement.executeBatch();//返回值是一个数组，数组的元素为每条语句影响到的行数
            for (int i : ii) {
                System.out.println(i);

            }
            JDBCUtils.release(null, statement, connection);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //插入10条记录   这个时候用PreparedStatement   适合与语句不同，但是参数不同的情况
    @Test
    public void test2() {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into t1 values (?,?)");
            for (int i = 0; i < 10; i++) {
                statement.setInt(1, i + 1);
                statement.setString(2, "aaa" + (i + 1));
                statement.addBatch();
            }
            statement.executeBatch();
            JDBCUtils.release(null, statement, connection);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //插入10000000条记录   这个时候用PreparedStatement   适合与语句不同，但是参数不同的情况
    @Test
    public void test3() {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into t1 values (?,?)");
            for (int i = 0; i < 1000000; i++) {
                statement.setInt(1, i + 1);
                statement.setString(2, "aaa" + (i + 1));
                statement.addBatch();
                if (i % 1000 == 0) {
                    statement.executeBatch();
                    statement.clearBatch();//运行完之后要把缓存清除掉
                }
            }
            statement.executeBatch();
            JDBCUtils.release(null, statement, connection);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
