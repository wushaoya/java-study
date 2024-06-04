package com.wusy.designpatterns.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 10:18
 */
public class Caretaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void addMemento(Memento memento) {
        mementoList.add(memento);
    }

    public Memento getMemento(int index) {
        return mementoList.get(index);
    }
}
