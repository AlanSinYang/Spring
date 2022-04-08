package com.kuang.pojo;

public class UserT {

    public UserT() {
        System.out.println("UserT创建成功");
    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println("name="+name);
    }
}
