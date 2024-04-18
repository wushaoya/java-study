package com.wusy.designpatterns.creational.builder;

/**
 * @Author wushaoya
 * @date 2024-04-15
 * Time: 17:18
 */
public class Client {
    public static void main(String[] args) {
        Director director = new Director();
        ConcreteBuilder builder = new ConcreteBuilder();

        Product product = director.construct(builder);
        product.show();
    }
}
