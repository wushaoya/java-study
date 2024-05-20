package com.wusy.designpatterns.behavioral.mediator;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:26
 */
public class ConcreteMediator implements Mediator {
    private Colleague colleague1;
    private Colleague colleague2;

    public void setColleague1(Colleague colleague) {
        this.colleague1 = colleague;
    }

    public void setColleague2(Colleague colleague) {
        this.colleague2 = colleague;
    }

    @Override
    public void sendMessage(String message, Colleague colleague) {
        if (colleague == colleague1) {
            colleague2.receiveMessage(message);
        } else {
            colleague1.receiveMessage(message);
        }
    }
}

