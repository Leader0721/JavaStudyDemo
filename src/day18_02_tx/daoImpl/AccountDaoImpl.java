package day18_02_tx.daoImpl;

import day18_02_tx.bean.Account;
import day18_02_tx.dao.AccountDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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
    private Connection connection;

    public AccountDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Account findByName(String accountName) {
        try {
            return qr.query(connection, "select * from account where name= ?", new BeanHandler<Account>(Account.class), accountName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            qr.update(connection, "update account set money=? where id =?", account.getMoney(), account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
