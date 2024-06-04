package com.wusy.designpatterns.behavioral.memento;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 10:18
 */
public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
