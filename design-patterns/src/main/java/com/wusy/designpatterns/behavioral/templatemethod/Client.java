package com.wusy.designpatterns.behavioral.templatemethod;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 15:32
 */
public class Client {
    public static void main(String[] args) {
        AbstractClass object1 = new ConcreteClassA();
        object1.templateMethod();

        System.out.println("--------------------");

        AbstractClass object2 = new ConcreteClassB();
        object2.templateMethod();
    }
}
