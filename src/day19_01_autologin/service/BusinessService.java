package day19_01_autologin.service;

import day19_01_autologin.bean.User;

/**
 * Created by 83731 on 2017/11/05.
 */
public interface BusinessService {
    /**
     * 用户登录
     * @param username
     * @param password 密码一定要加密
     * @return 用户名或者密码错误直接返回一个null
     */

    User login(String username,String password);
}
