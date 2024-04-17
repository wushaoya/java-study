package com.wusy.designpatterns.creational.abstractfactory;

/**
 * @Author wushaoya
 * @date 2024-04-12
 * Time: 15:38
 */
public class FactoryA implements Factory {
    @Override
    public Product create() {
        return new ProductA();
    }
}
