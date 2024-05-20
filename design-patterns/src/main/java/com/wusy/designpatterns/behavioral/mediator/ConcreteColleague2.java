package com.wusy.designpatterns.behavioral.mediator;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:27
 */
public class ConcreteColleague2 implements Colleague {
    private Mediator mediator;

    public ConcreteColleague2(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("colleague2收到信息: " + message);
    }
}
