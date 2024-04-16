package com.wusy.designpatterns.creational.factorymethod;

/**
 * @Author wushaoya
 * @date 2024-04-12
 * Time: 15:39
 */
public class Client {

    public static void main(String[] args) {
        Product productA = Factory.getProduct("A");
        productA.produce();
        Product productB = Factory.getProduct("B");
        productB.produce();
    }
}
