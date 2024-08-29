package com.wusy.designpatterns.behavioral.templatemethod;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 15:32
 */
public class ConcreteClassB extends AbstractClass {

    @Override
    void operation1() {
        System.out.println("实现类B第一步操作");
    }

    @Override
    void operation2() {
        System.out.println("实现类B第二步操作");
    }
}
