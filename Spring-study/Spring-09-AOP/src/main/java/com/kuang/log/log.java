package com.kuang.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class log implements MethodBeforeAdvice {

//    method : 要执行的目标对象的方法
//    args   : 参数
//    target : 对象
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass()+"的"+method.getName()+"被执行了");
    }
}
