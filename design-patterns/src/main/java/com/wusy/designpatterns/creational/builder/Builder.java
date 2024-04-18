package com.wusy.designpatterns.creational.builder;

/**
 * @Author wushaoya
 * @date 2024-04-15
 * Time: 17:17
 */
public interface Builder {
    void buildPartA();

    void buildPartB();

    void buildPartC();

    Product getResult();
}
