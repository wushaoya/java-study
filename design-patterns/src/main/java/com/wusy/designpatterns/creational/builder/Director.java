package com.wusy.designpatterns.creational.builder;

/**
 * @Author wushaoya
 * @date 2024-04-15
 * Time: 17:18
 */
public class Director {
    public Product construct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
