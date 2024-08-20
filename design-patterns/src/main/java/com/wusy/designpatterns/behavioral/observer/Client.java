package com.wusy.designpatterns.behavioral.observer;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:09
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new Subject();
        ConcreteObserver observer1 = new ConcreteObserver();
        ConcreteObserver observer2 = new ConcreteObserver();
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        subject.notifyObservers();
    }
}
