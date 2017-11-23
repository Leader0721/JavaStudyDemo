package day19_01_autologin.dao;

import day19_01_autologin.bean.User;

/**
 * Created by 83731 on 2017/11/05.
 */
public interface UserDao {
    User query(String username,String password);
}
