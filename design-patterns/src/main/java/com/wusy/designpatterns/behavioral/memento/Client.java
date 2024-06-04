package com.wusy.designpatterns.behavioral.memento;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 10:18
 */
public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("State1");
        caretaker.addMemento(originator.saveStateToMemento());
        originator.setState("State2");
        caretaker.addMemento(originator.saveStateToMemento());
        originator.setState("State3");
        System.out.println("最新状态: " + originator.getState());
        originator.getStateFromMemento(caretaker.getMemento(0));
        System.out.println("第一次保存的状态: " + originator.getState());
        originator.getStateFromMemento(caretaker.getMemento(1));
        System.out.println("第二次保存的状态: " + originator.getState());
    }
}
