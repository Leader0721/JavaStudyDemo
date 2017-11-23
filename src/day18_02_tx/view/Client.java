package day18_02_tx.view;

import day18_02_tx.service.BusinessService;
import day18_02_tx.serviceImpl.BusinessServiceImpl;

/**
 * Created by 83731 on 2017/10/29.
 */
public class Client {
    public static void main(String[] args) {
        BusinessService s = new BusinessServiceImpl();
        s.transfer("aaa", "bbb", 100);
    }
}
