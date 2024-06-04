package com.wusy.designpatterns.behavioral.memento;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 10:17
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
