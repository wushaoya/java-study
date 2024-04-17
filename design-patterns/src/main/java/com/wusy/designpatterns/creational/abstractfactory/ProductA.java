package com.wusy.designpatterns.creational.abstractfactory;

/**
 * @Author wushaoya
 * @date 2024-04-12
 * Time: 15:36
 */
public class ProductA implements Product {
    @Override
    public void produce() {
        System.out.println("生产A产品.");
    }
}
