package com.wusy.designpatterns.behavioral.observer;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:08
 */
public class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("主题变更");
    }
}
