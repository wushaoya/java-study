package com.wusy.designpatterns.behavioral.mediator;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:27
 */
public class Client {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        ConcreteColleague1 colleague1 = new ConcreteColleague1(mediator);
        ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);

        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        colleague1.sendMessage("hello colleague2!");
        colleague2.sendMessage("Hi colleague1!");
    }
}
