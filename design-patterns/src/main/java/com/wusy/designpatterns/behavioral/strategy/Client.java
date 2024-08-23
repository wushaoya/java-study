package com.wusy.designpatterns.behavioral.strategy;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 15:42
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        context.executeStrategy(10, 5);

        context = new Context(new OperationSubtract());
        context.executeStrategy(10, 5);

        context = new Context(new OperationMultiply());
        context.executeStrategy(10, 5);
    }
}
