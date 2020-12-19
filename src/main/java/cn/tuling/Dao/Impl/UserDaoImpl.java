package cn.tuling.Dao.Impl;

import cn.tuling.Dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    public void getUser() {
        System.out.println("查询数据库");
    }
}
