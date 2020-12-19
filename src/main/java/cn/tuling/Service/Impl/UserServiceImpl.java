package cn.tuling.Service.Impl;

import cn.tuling.Dao.UserDao;
import cn.tuling.Service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserDao userDao;

    public void getUser() {
        userDao.getUser();
    }
}
