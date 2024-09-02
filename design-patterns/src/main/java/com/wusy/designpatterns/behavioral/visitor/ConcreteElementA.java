package com.wusy.designpatterns.behavioral.visitor;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:51
 */
public class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationA() {
        return "元素A操作";
    }
}
