package com.wusy.designpatterns.structural.proxy.statical;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 15:07
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("发送请求");
    }
}
