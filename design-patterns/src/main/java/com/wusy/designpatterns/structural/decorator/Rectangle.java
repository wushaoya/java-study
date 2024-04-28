package com.wusy.designpatterns.structural.decorator;

/**
 * @Author wushaoya
 * @date 2024-04-16
 * Time: 14:10
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.print("长方形");
    }
}
