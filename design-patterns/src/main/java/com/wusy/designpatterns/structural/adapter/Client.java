package com.wusy.designpatterns.structural.adapter;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 11:13
 */
public class Client {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        target.request();
    }
}
