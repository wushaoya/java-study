package com.wusy.designpatterns.behavioral.templatemethod;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 15:31
 */
public class ConcreteClassA extends AbstractClass {

    @Override
    void operation1() {
        System.out.println("实现类A第一步操作");
    }

    @Override
    void operation2() {
        System.out.println("实现类A第二步操作");
    }
}
