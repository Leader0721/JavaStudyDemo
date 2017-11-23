package day16jdbc;

import day15jdbc01.utils.JDBCUtils;
import org.junit.Test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/**
 * 如何调用已经存在的存储过程
 * <p>
 * <p>
 * create procedure demosp(in inputparam varchar(255),
 * inout inoutparam varchar(255)) begin select
 * contact('zyxw--',inputparam) into inoutparam; end $$
 * <p>
 * <p>
 * Created by 83731 on 2017/09/19.
 */
public class CallableDemo {
    @Test
    public void test01() throws Exception {
        Connection connection = JDBCUtils.getConnection();
        CallableStatement statement = connection.prepareCall("{call demosp(?,?)}");
        //输入参数：设置值
        //输出参数:告知数据类型即可
        statement.setString(1, "yy");
        statement.registerOutParameter(2, Types.VARCHAR);
        statement.execute();
        //打印执行的结果
        System.out.println(statement.getString(2));
        JDBCUtils.release(null, statement, connection);

    }


    @Test
    public void test1() throws Exception{
        Connection conn = JdbcUtil.getConnection();
        CallableStatement stmt = conn.prepareCall("{call demoSp(?,?)}");
        //输入参数：设置值
        //输出参数：注册数据类型即可
        stmt.setString(1, "YY");
        stmt.registerOutParameter(2, Types.VARCHAR);

        stmt.execute();
        //打印执行的结果
        System.out.println(stmt.getString(2));
        JdbcUtil.release(null, stmt, conn);
    }
}
