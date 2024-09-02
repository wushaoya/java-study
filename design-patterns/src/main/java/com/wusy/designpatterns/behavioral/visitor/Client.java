package com.wusy.designpatterns.behavioral.visitor;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:52
 */
public class Client {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        Visitor visitor = new ConcreteVisitor();

        objectStructure.accept(visitor);
    }
}
