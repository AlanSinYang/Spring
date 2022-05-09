package com.kuang.demo04;

import com.kuang.demo02.UserService;
import com.kuang.demo02.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
//        真实角色
        UserServiceImpl userService = new UserServiceImpl();
        ProxyInvocationHandler pih = new ProxyInvocationHandler();

        pih.setTarget(userService);//设置需要代理的对象
//        动态生成代理类
        UserService proxy = (UserService) pih.getproxy();

        proxy.upata();
    }
}
