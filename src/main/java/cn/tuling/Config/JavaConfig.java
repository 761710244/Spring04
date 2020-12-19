package cn.tuling.Config;

import cn.tuling.Model.MyImportBeanDefinition;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * 用户标记一个Spring配置类
 * 之前是根据xml启动Spring
 * 此处Configuration相当于xml文件的<beans></beans>
 */
@Configuration
/**
 * 之前需要在xml中配置<context:component-scan base-package="cn.tulingxueyuan"
 * 此处修改为@ComponentScan(basePackages = "cn.tuling")
 */
@ComponentScan(basePackages = "cn.tuling")  //  不能省略
/**
 * 使用@PropertySource注解可配置外部属性，配合@Value进行使用，Value可省略
 */
@PropertySource("db.properties")
/**
 *  1.在主配置类引用其他的config配置类
 *  2.将类注册为Bean
 *  3.导入ImportSelector实现类，可以注册多个Bean
 *  4.ImportBeanDefinitionRegistrar实现类，可以注册多个BeanDefinition
 */
//@Import(SecondJavaConfig.class)
//@Import(MyImportSelector.class)
@Import(MyImportBeanDefinition.class)
public class JavaConfig {

    @Value("${mysql.username}")
    private String username;
    @Value("${mysql.password}")
    private String password;
    @Value("${mysql.url}")
    private String url;
    @Value("${mysql.driverClassName}")
    private String driverClassName;

    /**
     * 相当于之前的：
     * <!--配置第三方bean-->
     * <bean class="com.alibaba.druid.pool.DruidDataSource" id="dataSource">
     * <property name="username" value="${mysql.username}"></property>
     * <property name="password" value="${mysql.password}"></property>
     * <property name="url" value="${mysql.url}"></property>
     * <property name="driverClassName" value="${mysql.driverClassName}"></property>
     * </bean>
     * <p>
     * 可以设置生命周期：@Bean(initMethod = "xxx") @Bean(destroyMethod = "xxx")
     * 可以自定义命名作为Bean的名字：@Bean(name = "xxx")
     * 将一个实例交给Spring，不同于Controller等四个,其四个是将类交给Spring
     * <p>
     * 引用外部类：直接在方法里面传入需要依赖的参数，无需@Autowired
     * 引用内部类：直接调用方法即可
     */
    @Bean
//    @Scope("singleton")   设置作用域：单例或多例
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setName(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }
}
