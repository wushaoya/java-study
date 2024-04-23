package com.wusy.designpatterns.structural.adapter;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 11:13
 */
public class Adapter implements Target{
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
