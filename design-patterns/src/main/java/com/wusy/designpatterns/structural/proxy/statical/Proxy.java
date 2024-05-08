package com.wusy.designpatterns.structural.proxy.statical;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 15:08
 */
public class Proxy implements Subject {
    private RealSubject realSubject;

    public Proxy() {
        this.realSubject = new RealSubject();
    }

    @Override
    public void request() {
        System.out.println("开始代理");
        realSubject.request();
        System.out.println("结束代理");
    }
}
