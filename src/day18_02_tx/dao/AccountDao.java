package day18_02_tx.dao;

import day18_02_tx.bean.Account;

/**
 *
 * Created by 83731 on 2017/10/29.
 *
 * DAO层不能牵扯到任何业务有关的逻辑
 * DAO只负责往数据库中变化数据  也就是只负责和数据库进行交互
 *
 *
 *
 */
public interface AccountDao {
    /**
     * 根据户名进行数据查询
     * @param accountName
     * @return
     */
    Account findByName(String accountName);

    /**
     * 根据账户更新金额
     * @param account
     */
    void updateAccount(Account account);

}
