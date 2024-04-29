package com.wusy.designpatterns.structural.facade;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 14:29
 */
public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.operationFacade();
    }
}
