package com.wusy.designpatterns.creational.builder;

/**
 * @Author wushaoya
 * @date 2024-04-15
 * Time: 17:17
 */
public class ConcreteBuilder implements Builder{
    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.setPartA("Part A");
    }

    @Override
    public void buildPartB() {
        product.setPartB("Part B");
    }

    @Override
    public void buildPartC() {
        product.setPartC("Part C");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
