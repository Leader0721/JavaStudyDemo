package day19_01_autologin.daoImpl;

import day19_01_autologin.bean.User;
import day19_01_autologin.dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.DBCPUtil;

import java.sql.SQLException;

/**
 * Created by 83731 on 2017/11/05.
 */
public class UserDaoImpl implements UserDao {
    private QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());

    @Override
    public User query(String username, String password) {
        try {
            return qr.query("select * from user where username = ? and password = ?", new BeanHandler<User>(User.class), username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
