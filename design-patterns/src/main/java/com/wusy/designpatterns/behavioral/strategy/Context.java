package com.wusy.designpatterns.behavioral.strategy;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 15:42
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int num1, int num2) {
        strategy.doOperation(num1, num2);
    }
}
