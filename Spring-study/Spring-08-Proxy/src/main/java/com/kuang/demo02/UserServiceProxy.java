package com.kuang.demo02;

public class UserServiceProxy implements UserService{

    UserServiceImpl userService;
    public void setUserService(UserServiceImpl userService){
        this.userService = userService;
    }


    public void add() {
        log("add");
        userService.add();
    }

    public void delete() {
        log("delete");
        userService.add();
    }

    public void upata() {
        log("upata");
        userService.add();
    }

    public void query() {
        log("query");
        userService.add();
    }
//    日志方法
    public void log(String msg){
        System.out.println("使用了"+msg+"方法");
    }
}
