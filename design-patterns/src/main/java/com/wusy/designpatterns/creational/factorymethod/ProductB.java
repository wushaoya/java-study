package com.wusy.designpatterns.creational.factorymethod;

/**
 * @Author wushaoya
 * @date 2024-04-12
 * Time: 15:36
 */
public class ProductB implements Product{
    @Override
    public void produce() {
        System.out.println("生产B产品.");
    }
}
