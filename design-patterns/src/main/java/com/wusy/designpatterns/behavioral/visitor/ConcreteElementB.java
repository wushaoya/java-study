package com.wusy.designpatterns.behavioral.visitor;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:51
 */
public class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationB() {
        return "元素B操作";
    }
}
