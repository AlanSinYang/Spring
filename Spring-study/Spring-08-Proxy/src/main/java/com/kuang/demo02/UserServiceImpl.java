package com.kuang.demo02;

//真实对象
public class UserServiceImpl implements UserService {


    public void add() {
        System.out.println("增加一个用户");
    }

    public void delete() {

        System.out.println("删除一个用户");
    }

    public void upata() {
        System.out.println("修改一个用户");
    }

    public void query() {
        System.out.println("查询一个用户");
    }
}
