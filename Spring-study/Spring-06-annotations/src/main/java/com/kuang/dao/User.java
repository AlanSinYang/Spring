package com.kuang.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//等价于    <bean id="user" class="com.kuang.dao.User"/>
//@Component = 组件
@Component
@Scope("prototype")
public class User {

    public String name;
//    @Value注解
//    相当于<property name="name" value="阳仔"/>的简写
    @Value("阳仔")

    public void setName(String name){
        this.name = name;
    }
}
