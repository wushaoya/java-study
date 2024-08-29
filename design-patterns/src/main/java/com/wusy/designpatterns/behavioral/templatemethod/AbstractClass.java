package com.wusy.designpatterns.behavioral.templatemethod;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 15:31
 */
public abstract class AbstractClass {

    // 模板方法
    public void templateMethod() {
        operation1();
        operation2();
    }

    // 抽象方法1
    abstract void operation1();

    // 抽象方法2
    abstract void operation2();
}
