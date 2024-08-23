package com.wusy.designpatterns.behavioral.strategy;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 15:41
 */
public class OperationAdd implements Strategy {
    @Override
    public void doOperation(int num1, int num2) {
        System.out.println("Addition: " + (num1 + num2));
    }
}