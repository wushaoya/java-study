package com.wusy.designpatterns.behavioral.mediator;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:26
 */
public class ConcreteColleague1 implements Colleague {
    private Mediator mediator;

    public ConcreteColleague1(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("colleague1收到信息: " + message);
    }
}

