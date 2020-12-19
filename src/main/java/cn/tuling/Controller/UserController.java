package cn.tuling.Controller;

import cn.tuling.Service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    UserService service;

    public void getUser() {
        service.getUser();
    }
}
