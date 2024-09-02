package com.wusy.designpatterns.behavioral.visitor;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:51
 */
public interface Visitor {
    void visit(ConcreteElementA elementA);
    void visit(ConcreteElementB elementB);
}
