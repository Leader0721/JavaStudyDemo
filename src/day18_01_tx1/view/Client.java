package day18_01_tx1.view;

import day18_01_tx1.service.BusinessService;
import day18_01_tx1.serviceImpl.BusinessServiceImpl;

/**
 * Created by 83731 on 2017/10/29.
 */
public class Client {
    public static void main(String[] args) {
        BusinessService s = new BusinessServiceImpl();
        s.transfer("aaa", "bbb", 100);
    }
}
