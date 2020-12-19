package cn.tuling.tests;

import cn.tuling.Config.JavaConfig;
import cn.tuling.Controller.UserController;
import cn.tuling.Model.Person;
import cn.tuling.Model.User;
import cn.tuling.Model.Wife;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIocTest {

    ApplicationContext ioc;

    @Before
    public void before() {
        ioc = new AnnotationConfigApplicationContext(JavaConfig.class);
    }

    @Test
    public void test01() {
        UserController bean = ioc.getBean(UserController.class);
        System.out.println(bean);
        bean.getUser();
    }

    @Test
    public void test02() {
        User bean = ioc.getBean(User.class);
        System.out.println(bean.getName());
    }

    @Test
    public void test03() {
        DruidDataSource bean = ioc.getBean(DruidDataSource.class);
        System.out.println(bean);
    }

    @Test
    public void test04() {
        User bean = (User) ioc.getBean("user2");
        System.out.println(bean);
    }

    @Test
    public void test05() {
        Wife bean = ioc.getBean(Wife.class);
        System.out.println(bean.getName());
    }

    @Test
    public void test06() {
        Person bean = ioc.getBean(Person.class);
        System.out.println(bean.getName());
    }
}
