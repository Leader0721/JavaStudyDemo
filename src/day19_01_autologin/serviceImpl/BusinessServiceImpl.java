package day19_01_autologin.serviceImpl;

import day19_01_autologin.bean.User;
import day19_01_autologin.dao.UserDao;
import day19_01_autologin.daoImpl.UserDaoImpl;
import day19_01_autologin.service.BusinessService;
import day19_01_autologin.util.SecurityUtil;

/**
 * Created by 83731 on 2017/11/05.
 */
public class BusinessServiceImpl implements BusinessService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        password = SecurityUtil.md5(password);//这个是要加密后的
        return dao.query(username, password);
    }
}
