package com.wusy.designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:08
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
