package com.wusy.designpatterns.structural.facade;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 14:28
 */
public class Facade {
    private SubsystemA subsystemA;
    private SubsystemB subsystemB;

    public Facade() {
        this.subsystemA = new SubsystemA();
        this.subsystemB = new SubsystemB();
    }

    public void operationFacade() {
        subsystemA.operationA();
        subsystemB.operationB();
    }
}
