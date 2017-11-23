package day18_01_tx1.daoImpl;

import day18_01_tx1.dao.AccountDao;
import org.apache.commons.dbutils.QueryRunner;
import util.DBCPUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by 83731 on 2017/10/29.
 */
public class AccountDaoImpl implements AccountDao {

    //如果是这样写的话，update完之后，就会将这个链接放回数据库之中，这样就只能执行一条语句，会出错
//    private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

    //应该这样写
    private QueryRunner qr = new QueryRunner();


    @Override
    public void transfer(String sourceAccountName, String targetAccountName, float money) {
        Connection connection = null;

        try {
            connection = DBCPUtil.getConnection();
            connection.setAutoCommit(false);//开启事务
            //而且需要将这个和数据库连接的链接传给语句，而且两个语句必须使用的是同一个链接对象
            qr.update(connection, "update account set money = money-? where name=?", money, sourceAccountName);
//            int i = 1 / 0;
            qr.update(connection, "update account set money = money+? where name=?", money, targetAccountName);
        } catch (Exception e) {//一定要注意异常的种类，否则不会执行异常中的代码
            if (connection != null) {
                try {
                    connection.rollback();//如果转账的过程中出现了错误，这个时候要把这个链接尽心回退
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.commit();
                    connection.close();//最后才将这个链接传回池中
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
