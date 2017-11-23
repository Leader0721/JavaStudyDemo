package day18_01_tx1.service;

/**
 * Created by 83731 on 2017/10/29.
 */
public interface BusinessService {
    /**
     * 转账
     *
     * @param sourceAccountName 转出账户
     * @param targetAccountName 转入账户
     * @param money             金额
     */


    void transfer(String sourceAccountName, String targetAccountName, float money);

}
