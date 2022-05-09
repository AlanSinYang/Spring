package com.kuang.config;


import com.kuang.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


//这个也会被Spring容器托管,注册到容器中,因为它本来就是一个@Component
//@Configuration代表是一个配置类,就和我们之前看的Beans.xml
//"getUser"拿得到是因为@Bean已经注册了,不用@Componet注解也能拿到 @Configuration也是一样.
@Configuration
@ComponentScan("com.kuang.pojo")
public class MapConfig {

    //        注册一个Bean,就相当于我们之前写的一个Bean标签
//    这个方法的名字,就相当于Bean标签中的ID属性
//    这个方法的返回值,就相当于Bean标签中class属性
    @Bean("getuser")
//    使用@Bean注解的话 bean的id就是标注的方法名,可以在@Bean(name="")来设置id,也可以@Bean("")来设置 效果都一致
    public User getUser() {
        return new User(); //就是返回要注入到Bean的对象
    }
}
