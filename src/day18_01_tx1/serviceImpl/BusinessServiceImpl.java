package day18_01_tx1.serviceImpl;

import day18_01_tx1.dao.AccountDao;
import day18_01_tx1.daoImpl.AccountDaoImpl;
import day18_01_tx1.service.BusinessService;

/**
 * Created by 83731 on 2017/10/29.
 */
public class BusinessServiceImpl implements BusinessService {
    private AccountDao dao = new AccountDaoImpl();

    @Override
    public void transfer(String sourceAccountName, String targetAccountName, float money) {
        dao.transfer(sourceAccountName, targetAccountName, money);
    }
}
