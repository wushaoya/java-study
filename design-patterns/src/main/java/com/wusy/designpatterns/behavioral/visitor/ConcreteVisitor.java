package com.wusy.designpatterns.behavioral.visitor;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:52
 */
public class ConcreteVisitor implements Visitor {
    @Override
    public void visit(ConcreteElementA elementA) {
        System.out.println("访问者执行 " + elementA.operationA());
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        System.out.println("访问者执行 " + elementB.operationB());
    }
}
