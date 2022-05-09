package com.kuang.demo01;

public class Proxy implements Rent {
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    //    中介
    public void rent() {
        seeHouse();
        host.rent();
        HeTong();
        fare();
    }

    //    看房
    public void seeHouse() {
        System.out.println("中介带你看房");
    }

    //    签合同
    public void HeTong() {
        System.out.println("签租房合同");
    }

    //    收中介费
    public void fare() {
        System.out.println("收中介费");
    }
}
