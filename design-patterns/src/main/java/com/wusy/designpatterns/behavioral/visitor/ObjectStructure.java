package com.wusy.designpatterns.behavioral.visitor;

/**
 * @Author wushaoya
 * @date 2024-04-17
 * Time: 9:52
 */
public class ObjectStructure {
    private Element[] elements;

    public ObjectStructure() {
        elements = new Element[]{new ConcreteElementA(), new ConcreteElementB()};
    }

    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}
