package cn.tuling.Config;

import cn.tuling.Model.User;
import org.springframework.context.annotation.Bean;

public class SecondJavaConfig {

    @Bean
    public User user2() {
        return new User();
    }
}
