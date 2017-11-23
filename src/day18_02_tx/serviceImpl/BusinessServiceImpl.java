package day18_02_tx.serviceImpl;

import day18_02_tx.bean.Account;
import day18_02_tx.dao.AccountDao;
import day18_02_tx.daoImpl.AccountDaoImpl;
import day18_02_tx.service.BusinessService;
import util.DBCPUtil;

import java.sql.Connection;

/**
 * Created by 83731 on 2017/10/29.
 */
public class BusinessServiceImpl implements BusinessService {
    @Override
    public void transfer(String sourceAccountName, String targetAccountName, float money) {
        Connection connection = null;
        try {
            connection = DBCPUtil.getConnection();
            connection.setAutoCommit(false);
            AccountDao dao = new AccountDaoImpl(connection);
            Account sAccount = dao.findByName(sourceAccountName);
            Account tAccount = dao.findByName(targetAccountName);
            sAccount.setMoney(sAccount.getMoney() - money);
            tAccount.setMoney(tAccount.getMoney() + money);
            dao.updateAccount(sAccount);
            dao.updateAccount(tAccount);

        }catch (Exception e){


        }

    }
}
