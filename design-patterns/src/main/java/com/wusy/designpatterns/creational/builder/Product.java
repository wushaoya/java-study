package com.wusy.designpatterns.creational.builder;

/**
 * @Author wushaoya
 * @date 2024-04-15
 * Time: 17:16
 */
public class Product {
    private String partA;
    private String partB;
    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void show() {
        System.out.println("Product parts: " + partA + ", " + partB + ", " + partC);
    }
}
